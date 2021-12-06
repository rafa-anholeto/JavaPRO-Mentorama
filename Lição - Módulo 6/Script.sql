create table patients(
id int primary key,
nome varchar(50),
telefone varchar(11),
);


alter table patients 
add column birthdate varchar(12)


insert into patients 
(id, nome, telefone, birthdate)
values
(1, 'João Gomes', '94455-9875', '10/05/1970'),
(2, 'Giva Jones', '91575-7715', '28/03/1965'),
(3, 'Joel Silva', '94585-7855', '15/08/1983')


select * from patients p 


create table hospitalization_history(
date_and_entry_patient_hour varchar(50),
date_and_exit_patient_hour varchar(50),
description varchar(50),
id_patient int
);

alter table hospitalization_history 
add column response_doctor varchar(50)


alter table hospitalization_history 
add constraint fk_responseDoctor
foreign key (response_doctor)
references doctors(matricula)

insert into hospitalization_history 
(date_and_entry_patient_hour, date_and_exit_patient_hour, description, response_doctor, id_patient)
values
('10/11/2016 - 18:40', '10/11/2016 - 20:35', 'Flu problem', 5555, 2);




create table doctors(
matricula varchar(50) primary key,
nome varchar(50),
department int,
cargo varchar(50),
telefone varchar(12)
);


insert into doctors 
(nome, department, cargo, matricula)
values
('José de Carvalho', 1, 'Ortopedista', 1111),
('Renan Santos', 2, 'Cardiologista', 2222),
('Marcelo Dias', 2, 'Oftalmologista', 3333),
('Francisco Souza', 3, 'Psiquiatra', 4444),
('Davi Campos', 3, 'Pneumologista', 5555);

select * from doctors d 

select * from hospitalization_history hh 



select d."nomeMedico" , department from doctors d 

select * from doctors d 

select * from doctors d 
inner join hospitalization_history hh 
on d.matricula = hh.response_doctor
inner join patients p 
on p.id = hh.id_patient
order by p.id asc

select * from patients p 
inner join hospitalization_history hh 
on p.id = hh.id_patient
order by p.id asc




 

 

