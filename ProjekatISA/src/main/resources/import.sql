INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('1', 'CineStar','odlican','Ise Bajica 5','5','cinema','1');  
INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('3', 'Srpsko Narodno pozoriste','dobar','Marije Magdalene 6','3','theatre','3');  
INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('4' ,'Umetnicko pozoriste','srednje','Bulevar Oslobodjenja 100','3','theatre','4');
INSERT INTO `isa`.`cinematheatre` (`id`,`name`,`description`,`address`,`rating`,`cinema`,`repertory_id`) VALUES ('5' ,'Bioskop','vrlo dobar','Mihajla Pupina 11','4','cinema','2');

INSERT INTO `isa`.`user` (`id`, `email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`, `role`,`admin_fchangep`,`numberlogin`) VALUES ('1', 'dragan.dulic1@gmail.com', 'Dragan', 'Dulic', 'v', 'Bukovac', '061555333', 1,'user','yes','0');

INSERT INTO `isa`.`user` (`id`,  `email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`, `role`,`admin_fchangep`,`numberlogin`) VALUES ('2', 'grujica995@gmail.com', 'Aleksandra', 'Grujic', 'sa', 'Novi Sad', '0647896543', 1,'user','yes','0');

INSERT INTO `isa`.`user` (`id`, `email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`, `role`,`admin_fchangep`,`numberlogin`) VALUES ('4', 'admin', 'Marko', 'Markovic', 'admin', 'Nis', '065786756', 1,'adminF','no','0');
INSERT INTO `isa`.`user` (`id`, `email`, `name`, `surname`, `password`, `city`, `phone_number`, `active`, `role`,`admin_fchangep`,`numberlogin`) VALUES ('5', 'admin1', 'Jelena', 'Jelenic', 'admin1', 'Subotica', '069341523', 1,'adminS','yes','0');


INSERT INTO `isa`.`thematicprops` (`id`, `description`, `name`, `price`, `cinema_theatre_id`,`user_id`,`reserved`) VALUES ('1','suncane naocar','naocareee','500','1','1',0);
INSERT INTO `isa`.`thematicprops` (`id`, `description`, `name`, `price`, `cinema_theatre_id`,`reserved`) VALUES ('2','Zelena kapa','Kapa','200','3',0);
INSERT INTO `isa`.`thematicprops` (`id`, `description`, `name`, `price`, `cinema_theatre_id`,`reserved`) VALUES ('3','zuta kapa','Kapa','200','3',0);

INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('123','2','1',0);
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('888','3','1',0);
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('222','1','3',0); 
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('444','3','3',0);
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('555','2','2',0); 
INSERT INTO `isa`.`bid` (`offered`,`user_id`,`announcement_id`,`accept`) VALUES ('777','3','2',0);

INSERT INTO `isa`.`announcement` (`name`,`user_id`,`approved`,`description`,`date`,`sold`) VALUES ('Privezak','1',1,'Plavi sa zutim','2018-10-30T07:08:09',0); 
INSERT INTO `isa`.`announcement` (`name`,`user_id`,`approved`,`description`,`date`,`sold`) VALUES ('Oglas1','1',1,'new cd','2018-04-22T07:08:09',0); 
INSERT INTO `isa`.`announcement` (`name`,`user_id`,`approved`,`description`,`date`,`sold`) VALUES ('Oglas2','2',1,'new ball','2018-04-22T07:08:09',0); 
INSERT INTO `isa`.`announcement` (`name`,`user_id`,`approved`,`description`,`date`,`sold`) VALUES ('Oglas3','2',1,'new cap','2018-04-22T07:08:09',0);

INSERT INTO `isa`.`repertory` (`id`) VALUES ('1');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('2');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('3');
INSERT INTO `isa`.`repertory` (`id`) VALUES ('4');

INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('1', 'Miloš Biković, Aglaya Tarasova','LED','113min','1');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('2', 'Dwayne Johnson, Kevin Hart','Džumandži: Dobrodošli u džunglu 3D','119min','1');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('3', 'Bella Thorne, Patrick Schwarzenegger','Ponoćno sunce','91min','2');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('4', 'Radoje Čupić, Jovana Stipić','Džandrljiv muž','80min','3');
INSERT INTO `isa`.`projection` (`id`, `actors`,`name`,`runtime`,`repertory_id`) VALUES ('5', 'Milan Kovačević, Aleksandar Gajin','Rodoljupci','95min','4');

INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('1','2018-04-22 00:00:00','2');
INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('2','2018-04-23 00:00:00','2');
INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('3','2018-04-23 00:00:00','1');
INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('4','2018-04-24 00:00:00','3');
INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('5','2018-04-18 00:00:00','2');
INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('6','2018-04-23 00:00:00','4');
INSERT INTO `isa`.`projectiondate` (`id`, `date`, `projection_id`) VALUES ('7','2018-04-23 00:00:00','5');

INSERT INTO `isa`.`hall` (`id`, `ordinal`, `cinematheatre_id`) VALUES ('1','1','1');
INSERT INTO `isa`.`hall` (`id`, `ordinal`, `cinematheatre_id`) VALUES ('3','2','1');
INSERT INTO `isa`.`hall` (`id`, `ordinal`, `cinematheatre_id`) VALUES ('2','1','5');
INSERT INTO `isa`.`hall` (`id`, `ordinal`, `cinematheatre_id`) VALUES ('4','1','3');
INSERT INTO `isa`.`hall` (`id`, `ordinal`, `cinematheatre_id`) VALUES ('5','1','4');

INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('1','200','2018-04-22 09:20','1','1');

INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('2','250','2018-04-22 09:00','1','1');

INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('3','300','2018-04-23 15:00','1','3');
INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('6','300','2018-04-23 16:00','3','2');
INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('4','400','2018-04-24 14:00','2','4');

INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('5','250','2018-04-18 21:00','1','5');
INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('7','200','2018-04-23 12:00','4','6');
INSERT INTO `isa`.`projectionterm` (`id`,`price`, `term`, `hall_id`, `projectiondate_id`) VALUES ('8','450','2018-04-23 17:00','5','7');


INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('1','1',1);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('2','2',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('3','3',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('4','4',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('5','5',1);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('6','6',1);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('7','7',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('8','8',0);

INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('9','1',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('10','2',1);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('11','3',1);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('12','4',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('13','5',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('14','6',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('15','7',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('16','8',0);

INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('17','1',1);

INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('18','1',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('19','2',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('20','3',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('21','4',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('22','5',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('23','6',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('24','7',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('25','8',0);

INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('26','1',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('27','2',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('28','3',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('29','4',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('30','5',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('31','6',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('32','7',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('33','8',0);

INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('34','1',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('35','2',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('36','3',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('37','4',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('38','5',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('39','6',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('40','7',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('41','8',0);

INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('42','1',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('43','2',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('44','3',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('45','4',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('46','5',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('47','6',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('48','7',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('49','8',0);

INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('50','1',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('51','2',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('52','3',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('53','4',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('54','5',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('55','6',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('56','7',0);
INSERT INTO `isa`.`seat` (`id`, `ordinal`, `reserved`) VALUES ('57','8',0);


INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('1','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('2','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('3','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('4','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('5','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('6','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('7','1');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('8','1');

INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('9','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('10','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('11','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('12','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('13','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('14','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('15','2');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('16','2');

INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('17','5');

INSERT INTO `isa`.`seat_projectiont` (`seat_id`,`projectiont_id`) VALUES ('18','6');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`,`projectiont_id`) VALUES ('19','6');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`,`projectiont_id`) VALUES ('20','6');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`,`projectiont_id`) VALUES ('21','6');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`,`projectiont_id`) VALUES ('22','6');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`,`projectiont_id`) VALUES ('23','6');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`,`projectiont_id`) VALUES ('24','6');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`,`projectiont_id`) VALUES ('25','6');

INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('26','3');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('27','3');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('28','3');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('29','3');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('30','3');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('31','3');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('32','3');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('33','3');

INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('34','4');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('35','4');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('36','4');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('37','4');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('38','4');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('39','4');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('40','4');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('41','4');

INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('42','7');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('43','7');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('44','7');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('45','7');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('46','7');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('47','7');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('48','7');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('49','7');

INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('50','8');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('51','8');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('52','8');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('53','8');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('54','8');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('55','8');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('56','8');
INSERT INTO `isa`.`seat_projectiont` (`seat_id`, `projectiont_id`) VALUES ('57','8');

INSERT INTO `isa`.`reservation` (`id`, `datea`, `ordinal`,`projectiona`, `projectionterm_id`, `user1_id`) VALUES ('1','22.04.2018','1','Džumandži: Dobrodošli u džunglu 3D','1','2');
INSERT INTO `isa`.`reservation` (`id`, `datea`, `ordinal`,`projectiona`, `projectionterm_id`, `user1_id`) VALUES ('2','22.04.2018','2','Džumandži: Dobrodošli u džunglu 3D','2','2');
INSERT INTO `isa`.`reservation` (`id`, `datea`, `ordinal`,`projectiona`, `projectionterm_id`, `user1_id`) VALUES ('3','22.04.2018','3','Džumandži: Dobrodošli u džunglu 3D','1','1');
INSERT INTO `isa`.`reservation` (`id`, `datea`, `name_cin`, `ordinal`,`projectiona`, `projectionterm_id`, `user1_id`) VALUES ('4','18.04.2018','CineStar','4','Džumandži: Dobrodošli u džunglu 3D','5','2');


INSERT INTO `isa`.`reservation_seats` (`reservation_id`,`seats_id`) VALUES ('1','1');
INSERT INTO `isa`.`reservation_seats` (`reservation_id`,`seats_id`) VALUES ('2','11');
INSERT INTO `isa`.`reservation_seats` (`reservation_id`,`seats_id`) VALUES ('2','10');
INSERT INTO `isa`.`reservation_seats` (`reservation_id`,`seats_id`) VALUES ('3','5');
INSERT INTO `isa`.`reservation_seats` (`reservation_id`,`seats_id`) VALUES ('3','6');
INSERT INTO `isa`.`reservation_seats` (`reservation_id`,`seats_id`) VALUES ('4','17');
