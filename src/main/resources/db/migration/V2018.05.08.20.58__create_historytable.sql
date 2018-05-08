CREATE TABLE `history` (
  `ID` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `Diseases` varchar(1024) NOT NULL,
  `Symptoms` varchar(1024) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `history`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UserId` (`UserId`);

ALTER TABLE `history`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;