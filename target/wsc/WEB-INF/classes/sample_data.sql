USE db_user2;

SET AUTOCOMMIT=0;
START TRANSACTION;
/*
 * Sample customer data
 */
INSERT INTO `kunden` (`nachname`, `vorname`, `telefonnummer`, `email`)
VALUES
	('aaanachname', 'aaavorname', '123456', ''),
	('bbbnachname', 'bbbvorname', 'telefonnummer1', 'a@xy.com'),
	('cccnachname', 'cccvorname', 'telefonnummer2', 'b@xy.com'),
	('dddnachname', 'dddvorname', '23626346', 'c@xy.com'),
	('eeenachname', 'eeevorname', '2315345', 'd@xy.com'),
	('fffnachname', 'fffvorname', '54567334262', 'e@xy.com'),
	('gggnachname', 'gggvorname', '45674', 'f@xy.com'),
	('hhhnachname', 'hhhvorname', '6734', 'g@xy.com'),
	('iiinachname', 'iiivorname', '45674', 'h@xy.com'),
	('jjjnachname', 'jjjvorname', '34563425', 'i@xy.com'),
	('kkknachname', 'kkkvorname', '456734567', 'j@xy.com'),
	('lllnachname', 'lllvorname', '45687456', 'k@xy.com'),
	('mmmnachname', 'mmmvorname', '68734567', 'l@xy.com'),
	('nnnnachname', 'nnnvorname', '34573457', 'm@xy.com'),
	('<h1>ooonachname</h1>', '<h1>ooovorname</h1>', '<h1>34573457</h1>', '<h1>m@xy.com</h1>'),
	('pppnachname', 'pppvorname', '3863', 'n@xy.com'),
	('qqqnachname', 'qqqvorname', '4573457', 'o@xy.com'),
	('rrrnachname', 'rrrvorname', '34567', 'p@xy.com'),
	('sssnachname', 'sssvorname', '35673456', 'q@xy.com'),
	('tttnachname', 'tttvorname', '45684568', 'r@xy.com'),
	('uuunachname', 'uuuvorname', 'ert56745', 's@xy.com'),
	('vvvnachname', 'vvvvorname', '6874568', 't@xy.com'),
	('wwwnachname', 'wwwvorname', '34573457', 'u@xy.com'),
	('xxxnachname', 'xxxvorname', '56873457', 'v@xy.com')
;

/*
 * Sample address data
 */
INSERT INTO `kunden_adressen` (`kundennummer`, `strasse`, `hausnummer`, `plz`, `ort`, `primaer`) VALUES
(1, 'aaaastr', '513', '12345', 'aaaaort', 1),
(1, 'aaabstr', '32', '54342', 'aaabort', 0),
(2, 'bbbastr', '63', '23567', 'bbbaort', 0),
(2, 'bbbbstr', '45', '85426', 'bbbbort', 1),
(3, 'cccstr', '513', '12345', 'cccort', 1),
(4, 'dddstr', '32', '54342', 'dddort', 1),
(5, 'eeeastr', '63', '23567', 'eeeaort', 0),
(5, 'eeebstr', '45', '85426', 'eeebort', 1),
(5, 'eeecstr', '513', '12345', 'eeecort', 0),
(6, 'gggstr', '32', '54342', 'gggort', 1),
(7, 'hhhstr', '63', '23567', 'hhhort', 1),
(8, 'iiiastr', '45', '85426', 'iiiaort', 1),
(9, 'jjjstr', '513', '12345', 'jjjort', 1),
(8, 'iiibstr', '32', '54342', 'iiibort', 0),
(10, 'kkkstr', '63', '23567', 'kkkort', 1),
(11, 'lllastr', '45', '85426', 'lllaort', 0),
(11, 'lllbstr', '513', '12345', 'lllbort', 1),
(12, 'mmmstr', '32', '54342', 'mmmort', 1),
(13, 'nnnstr', '63', '23567', 'nnnort', 1),
(14, 'oooastr', '45', '85426', 'oooaort', 0),
(14, 'ooobstr', '513', '12345', 'ooobort', 1),
(14, 'ooocstr', '32', '54342', 'ooocort', 0),
(15, 'pppastr', '63', '23567', 'pppaort', 1),
(15, 'pppbstr', '45', '85426', 'pppbort', 0),
(16, 'qqqstr', '513', '12345', 'qqqort', 1),
(17, 'rrrstr', '32', '54342', 'rrrort', 1),
(18, 'sssstr', '63', '23567', 'sssort', 1),
(19, 'tttstr', '45', '85426', 'tttort', 1),
(20, 'uuustr', '513', '12345', 'uuuort', 1),
(21, 'vvvstr', '32', '54342', 'vvvort', 1),
(22, 'wwwstr', '63', '23567', 'wwwort', 1),
(23, 'xxxstr', '45', '85426', 'xxxort', 1),
(24, 'yyystr', '45', '85426', 'yyyort', 1);

COMMIT;