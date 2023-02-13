-- This script gets executed only when connecting to H2. It is not executed when we connect to a database

insert into todo (ID,USERNAME,DESCRIPTION,TARGET_DATE,DONE)
values (10001,'validUser','GET AWS Certificate', CURRENT_DATE(),false);
insert into todo (ID,USERNAME,DESCRIPTION,TARGET_DATE,DONE)
values (10002,'validUser','GET Azure Certificate', CURRENT_DATE(),false);
insert into todo (ID,USERNAME,DESCRIPTION,TARGET_DATE,DONE)
values (10003,'validUser','GET GCP Certificate', CURRENT_DATE(),false);
insert into todo (ID,USERNAME,DESCRIPTION,TARGET_DATE,DONE)
values (10004,'validUser','Learn Devops', CURRENT_DATE(),false);
