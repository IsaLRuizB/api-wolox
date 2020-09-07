INSERT INTO `usuario` (`id`, `email`, `name`, `phone`, `username`, `web_site`) VALUES
	(1, 'Sincere@april.biz', 'Leanne Graham', '1-770-736-8031 x56442', 'Bret', NULL),
	(2, 'Shanna@melissa.tv', 'Ervin Howell', '010-692-6593 x09125', 'Antonette', NULL),
	(3, 'Nathan@yesenia.net', 'Clementine Bauch', '1-463-123-4447', 'Samantha', NULL),
	(4, 'Julianne.OConner@kory.org', 'Patricia Lebsack', '493-170-9623 x156', 'Karianne', NULL),
	(5, 'Lucio_Hettinger@annie.ca', 'Chelsey Dietrich', '(254)954-1289', 'Kamren', NULL),
	(6, 'Karley_Dach@jasper.info', 'Mrs. Dennis Schulist', '1-477-935-8478 x6430', 'Leopoldo_Corkery', NULL),
	(7, 'Telly.Hoeger@billy.biz', 'Kurtis Weissnat', '210.067.6132', 'Elwyn.Skiles', NULL),
	(8, 'Sherwood@rosamond.me', 'Nicholas Runolfsdottir V', '586.493.6943 x140', 'Maxime_Nienow', NULL),
	(9, 'Chaim_McDermott@dana.io', 'Glenna Reichert', '(775)976-6794 x41206', 'Delphine', NULL),
	(10, 'Rey.Padberg@karina.biz', 'Clementina DuBuque', '024-648-3804', 'Moriah.Stanton', NULL);

	INSERT INTO `permiso` (`id`, `id_album`, `id_user`, `id_user_comp`, `tipo_permiso`) VALUES
    	(1, 1, 1, 2, '1'),
    	(2, 2, 1, 2, '1'),
    	(3, 2, 1, 3, '1'),
    	(7, 1, 1, 3, '1'),
    	(8, 1, 1, 4, '2');