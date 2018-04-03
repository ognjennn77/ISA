INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('1', 'CineStar','odlican','Ise Bajica 5','5',1,'1');  
INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('3', 'Srpsko Narodno pozoriste','dobar','Marije Magdalene 6','3',0,'3');  
INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('4' ,'Umetnicko pozoriste','srednje','Bulevar Oslobodjenja 100','3',0,'2');
INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ( '5','Bioskop','vrlo dobar','Mihajla Pupina 11','4',1,'4');

INSERT INTO `isa`.`user` (`id`, `email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`) VALUES ('1', 'grujica995@gmail.com', 'Filip', 'Fica', 'IsaIsic1.', 'Beograd', '987654321', 1);  
INSERT INTO `isa`.`user` (`id`, `email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`) VALUES ('2', 'dragan.dulic1@gmail.com', 'Dragan', 'Dulic', 'IsaIsic1.', 'Novi Sad', '061555333', 1);  


INSERT INTO `isa`.`thematicprops` (`id`, `description`, `name`, `price`, `cinema_theatre_id`,`user_id`,`reserved`) VALUES ('1','suncane naocar','naocareee','500','1','1',0);
INSERT INTO `isa`.`thematicprops` (`id`, `description`, `name`, `price`, `cinema_theatre_id`,`user_id`,`reserved`) VALUES ('2','Zelena kapa','Kapa','200','3','2',0);

INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`) VALUES ('111','1','1'); 

INSERT INTO `isa`.`announcement` (`name`,`description`,`date`) VALUES ('Privezak','Plavi sa zutim','2018-10-30T07:08:09'); 



INSERT INTO `isa`.`repertory` (`id`) VALUES ('1');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('2');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('3');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('4');

INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('1', 'Miloš Biković, Aglaya Tarasova','LED','113min','1');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('2', 'Dwayne Johnson, Kevin Hart','Džumandži: Dobrodošli u džunglu 3D','119min','1');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('3', 'Bella Thorne, Patrick Schwarzenegger','Ponoćno sunce','91min','2');
