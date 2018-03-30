INSERT INTO `isa`.`cinematheatre` (`id`, `name`,`description`,`address`,`rating`,`cinema`) VALUES ('1', 'CineStar','odlican','Ise Bajica 5','5',1);
INSERT INTO `isa`.`cinematheatre` (`id`, `name`,`description`,`address`,`rating`,`cinema`) VALUES ('3', 'Bioskop','Vrlo dobar','Mihajla Pupina 11','4',1);
INSERT INTO `isa`.`cinematheatre` (`id`, `name`,`description`,`address`,`rating`,`cinema`) VALUES ('2', 'Srpsko Narodno pozoriste','dobar','Marije Magdalene 6','3',0);  
INSERT INTO `isa`.`cinematheatre` (`id`, `name`,`description`,`address`,`rating`,`cinema`) VALUES ('4', 'Umetnicko pozoriste','srednje','Bulevar Oslobodjenja 100','3',0);

INSERT INTO `isa`.`user` (`id`, `email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`) VALUES ('1', 'grujica995@gmail.com', 'Filip', 'Fica', 'IsaIsic1.', 'Beograd', '987654321', 1);  

INSERT INTO `isa`.`thematicprops` (`id`, `description`, `name`, `price`, `cinema_theatre_id`) VALUES ('1','suncane naocar','naocareee','500','1');

INSERT INTO `isa`.`repertory` (`id`,`cinema_theatre_id`) VALUES ('1','2');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('2');

INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('1', 'Miloš Biković, Aglaya Tarasova','LED','113min','1');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('2', 'Dwayne Johnson, Kevin Hart','Džumandži: Dobrodošli u džunglu 3D','119min','1');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('3', 'Bella Thorne, Patrick Schwarzenegger','Ponoćno sunce','91min','2');
