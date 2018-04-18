INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('1', 'CineStar','odlican','Ise Bajica 5','5',1,'1');  
INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('3', 'Srpsko Narodno pozoriste','dobar','Marije Magdalene 6','3',0,'3');  
INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('4' ,'Umetnicko pozoriste','srednje','Bulevar Oslobodjenja 100','3',0,'4');

INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('5' ,'Bioskop','vrlo dobar','Mihajla Pupina 11','4',1,'2');

INSERT INTO `isa`.`user` (`id`, `adminfanzone`, `email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`) VALUES ('1', 0, 'dragan.dulic1@gmail.com', 'Dragan', 'Dulic', 'v', 'Bukovac', '061555333', 1);
INSERT INTO `isa`.`user` (`id`, `adminfanzone`, `email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`) VALUES ('2', 0, 'grujica995@gmail.com', 'Aleksandra', 'Grujic', 'sa', 'Novi Sad', '0647896543', 1);
INSERT INTO `isa`.`user` (`id`, `adminfanzone`,`email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`) VALUES ('3', 0, 'donthavename3478@gmail.com', 'Nikola', 'Nikolic', 'sa2', 'Beograd', '063319583', 1);
INSERT INTO `isa`.`user` (`id`, `adminfanzone`,`email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`) VALUES ('4', 1, 'admin', 'Marko', 'Markovic', 'admin', 'Nis', '065786756', 1);
INSERT INTO `isa`.`user` (`id`, `adminfanzone`,`email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`) VALUES ('5', 1, 'admin1', 'Jelena', 'Jelenic', 'admin1', 'Subotica', '069341523', 1);


INSERT INTO `isa`.`thematicprops` (`id`, `description`, `name`, `price`, `cinema_theatre_id`,`user_id`,`reserved`) VALUES ('1','suncane naocar','naocareee','500','1','1',0);
INSERT INTO `isa`.`thematicprops` (`id`, `description`, `name`, `price`, `cinema_theatre_id`,`reserved`) VALUES ('2','Zelena kapa','Kapa','200','3',0);
INSERT INTO `isa`.`thematicprops` (`id`, `description`, `name`, `price`, `cinema_theatre_id`,`reserved`) VALUES ('3','zuta kapa','Kapa','200','3',0);

INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('123','2','1',0);
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('888','3','1',0);
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('222','1','3',0); 
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('444','3','3',0);
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('555','2','2',0); 
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('777','3','2',0);

INSERT INTO `isa`.`announcement` (`name`,`user_id`,`approved`,`description`,`date`) VALUES ('Privezak','1',1,'Plavi sa zutim','2018-10-30T07:08:09'); 
INSERT INTO `isa`.`announcement` (`name`,`user_id`,`approved`,`description`,`date`) VALUES ('Oglas1','1',1,'new cd','2018-04-22T07:08:09'); 
INSERT INTO `isa`.`announcement` (`name`,`user_id`,`approved`,`description`,`date`) VALUES ('Oglas2','2',1,'new ball','2018-04-22T07:08:09'); 
INSERT INTO `isa`.`announcement` (`name`,`user_id`,`approved`,`description`,`date`) VALUES ('Oglas3','2',1,'new cap','2018-04-22T07:08:09');

INSERT INTO `isa`.`repertory` (`id`) VALUES ('1');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('2');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('3');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('4');

INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('1', 'Miloš Biković, Aglaya Tarasova','LED','113min','1');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('2', 'Dwayne Johnson, Kevin Hart','Džumandži: Dobrodošli u džunglu 3D','119min','1');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('3', 'Bella Thorne, Patrick Schwarzenegger','Ponoćno sunce','91min','2');

INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('1','2018-04-09 00:00:00','2');
INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('2','2018-04-10 00:00:00','2');
INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('3','2018-04-11 00:00:00','1');
INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('4','2018-04-12 00:00:00','3');

INSERT INTO `isa`.`hall` (`id`, `ordinal`, `cinematheatre_id`) VALUES ('1','1','1');
INSERT INTO `isa`.`hall` (`id`, `ordinal`, `cinematheatre_id`) VALUES ('3','2','1');
INSERT INTO `isa`.`hall` (`id`, `ordinal`, `cinematheatre_id`) VALUES ('2','1','5');

INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('1','200','2018-04-09 15:00','1','1');

INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('2','250','2018-04-09 17:00','1','1');
INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('3','300','2018-04-11 15:00','1','3');
INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('4','400','2018-04-12 15:00','2','4');

INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('1','1',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('2','2',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('3','3',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('4','4',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('5','5',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('6','6',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('7','7',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('8','8',0);


INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('1','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('2','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('3','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('4','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('5','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('6','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('7','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('8','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('1','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('2','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('3','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('4','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('5','2');


INSERT INTO `isa`.`reservation` (`id`, `ordinal`, `projectionterm_id`, `user1_id`) VALUES ('1','1','1','2');
INSERT INTO `isa`.`reservation` (`id`, `ordinal`, `projectionterm_id`, `user1_id`) VALUES ('2','2','2','2');
INSERT INTO `isa`.`reservation` (`id`, `ordinal`, `projectionterm_id`, `user1_id`) VALUES ('3','3','1','1');


