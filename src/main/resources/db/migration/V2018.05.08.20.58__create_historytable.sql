CREATE TABLE `history` (
  `ID` int(11) NOT NULL,
  `Username` varchar(1024) NOT NULL,
  `Diseases` varchar(1024) NOT NULL,
  `Symptoms` varchar(1024) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `history`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `history`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

insert into history values (null, 'admin', 'cancer', 'febra, dureri, dureri insuportabile, simptom cancer', '2017-12-31 23:59:59');
insert into history values (null, 'admin', 'cancer', 'durere, ma doare ficatul cand urc scarile, tristete, simptom cancer2', '2017-06-30 13:59:59');
