-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2021 at 03:04 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `students`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `login_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `name`, `login_id`) VALUES
(1, 'sakan', 44),
(3, 'dilaksan', 63),
(4, 'arun', 64);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `fees` double DEFAULT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `duration`, `fees`, `name`) VALUES
(1, 50, 500000, 'JANU'),
(3, 50, 500000, 'JANUJAN');

-- --------------------------------------------------------

--
-- Table structure for table `lecturers`
--

CREATE TABLE `lecturers` (
  `id` int(11) NOT NULL,
  `education_detail` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `login_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturers`
--

INSERT INTO `lecturers` (`id`, `education_detail`, `name`, `course_id`, `login_id`) VALUES
(1, 'student', 'sanu', 1, 69);

-- --------------------------------------------------------

--
-- Table structure for table `logins`
--

CREATE TABLE `logins` (
  `id` int(11) NOT NULL,
  `password` longtext NOT NULL,
  `user_type` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logins`
--

INSERT INTO `logins` (`id`, `password`, `user_type`, `username`) VALUES
(15, '$2a$10$PDzxuRam8EacMKduTTPln..E6vaMngx4kPjjqlZXoH2k2nJithGoe', 'LECTURER', 'sakan'),
(2, '$2a$10$rNsZkbiOexbDR6mUIlsMnu/xoi2dmpYoz/1I0JNmzlSzLy.cnRwZS', 'USER', 'thanu'),
(4, '$2a$10$bSqkHpZEEx3CZ.L7xbHZZevc47byriXGY7WStDaVC9KPk1p97julG', 'USER', 'vishnu'),
(5, '$2a$10$UWSld7Rpv6IWn.qaLcXInuAvXwg6bX/ALdNXUI1r5bKcDpLiZrIQW', 'USER', 'mahes'),
(6, '$2a$10$3wxiAgHyzwj3hbQ/MvqrtesphGh2y.intqJYOYTYa7w/Yij4cndT2', 'LECTURER', 'dippi'),
(7, '$2a$10$EZcQd0NhV5LOQs937WXCkepa5FMLOpPSY8mbxC4a2UQqPZ1owYBlu', 'LECTURER', 'ravi'),
(8, '$2a$10$GtwzQSfX6sBmSYOwtPMouu5UHnGrTz4/fT7rv85dM0D4DgXVNZmGa', 'LECTURER', 'ravin'),
(9, '$2a$10$81Zk3le6O5zj.BnW6hmWw.HxG1MlkmeGQjebEJFSeDkxkKj5rE8Du', 'USER', 'kani'),
(10, '$2a$10$8cEKicg/i12SefJZEqtrw.8K6To.O6WA/83SwrFgjney09TFaseoC', 'USER', 'kani'),
(11, '$2a$10$JTEgzaq4VyN4RWjChPuL8./JzADT.atNJhELHJtK2lp/k5M6wubtW', 'USER', 'mari'),
(13, '$2a$10$YQ3cSwXVj..Mo9Cwu9J63OO07VWnGhRDmGymCX14ZflPtZYxeO3sK', 'LECTURER', 'sanukan'),
(16, '$2a$10$pjq4HZflSezEH944LzMnv.njXTrxOpI9cp5nGl30AJOfxiF6nGPqO', 'LECTURER', 'sak'),
(17, '$2a$10$GoOaRG6Rm80nMyGe2FX4AuEGrvwEZ8pHKbLZVzCEZZRHdBMUGvI3q', 'LECTURER', 'smk'),
(18, '$2a$10$gsuIpxcUOrFjVe91WBfIB.wRniNWyG.h.J6Cd.iCrc9dYTcadb2W2', 'LECTURER', 'janujan'),
(19, '$2a$10$nmsbd8wrcll0oMkUDHSJP.Ta4vofFUXh18x3QnQjyiJpcLzaoD4lO', 'STUDENT', 'januj'),
(20, '$2a$10$lp9fhf4Yc73rvArmIrBIXuJH66uSUeUulHzM2BjrLZiO9KKPQ58Nm', 'USER', 'vithu'),
(21, '$2a$10$tu7kxExcayQGNaLyMvrh2OMPhdOqvA57DLlHVdjx2NppTbvurFYj2', 'USER', 'nantha'),
(22, '$2a$10$Jrd/6qgko1uLVBsP.hMceOjiuApbvU1mxMQS5uMhrhGOe0NH5fl0C', 'LECTURER', 'mathumi'),
(23, '$2a$10$L6YcXzmF68xwNNXeft.wp.s1ldSX5EW1HetVxl85z4oUzC0Z6dKna', 'LECTURER', 'mathu'),
(24, '$2a$10$BbuN1FjeaB86EOJQIU7U4Oz9fSMlvKGoY3W0YpB2DAk65g4kZW2y6', 'LECTURER', 'math'),
(25, '$2a$10$gdzCcIa5eJE24T/InlYM0.vx0Xzk14LQPwGqz2tDc.Rki4x98ihyG', 'LECTURER', 'mat'),
(26, '$2a$10$pMZWVh9BFAPUYMyuYSpnOe.OuhVUzc.Wth3nFR513RgIOxQiNju02', 'LECTURER', 'matm'),
(27, '$2a$10$8dCicP5ZNl8yz69If2.PP.X6uEW9HaWT1hAezad3hNNtns1bLh25W', 'LECTURER', 'ma'),
(28, '$2a$10$MqZfeYoc84tMBcTex1R9y.vO8IsqJL..iQTzxo.XvpmVu1dod9CBa', 'LECTURER', 'man'),
(29, '$2a$10$TXz8VCevXxXLbi8UEARfn.4GBQ3gYE.5ER4aJ0aPymoZzRjpfDSLe', 'LECTURER', 'manl'),
(30, '$2a$10$QSAS1jzap/15CD2x0MRp8.Is2W7FCwEdSzIhm6BEo5es24u/YnezO', 'LECTURER', 'mpok'),
(31, '$2a$10$eOvLC.oU2LH0e8Glfp5um.8vdMZC080H6PHqRyowaQsorizDtJA96', 'LECTURER', 'mpo'),
(32, '$2a$10$sgy5W3EgLNhgG9ecOH2xk.7lnPi54qPc4zdR5IsFPvmGr0TZYlCvi', 'LECTURER', 'mpodd'),
(33, '$2a$10$G4kb.ahqdwqVbIykgWbP0elM1ryIRzv/dMz6k4voXoIfvBs.Q.kEq', 'LECTURER', 'mpod'),
(34, '$2a$10$YlIpaDGjTDI8.AgH4sJ4d.wlz.yaqsWYr9mTp6mY9Fnvtg./wcMEa', 'LECTURER', 'mpd'),
(35, '$2a$10$1GageSBGIDkrUzzC9wB0geywDIrNb5eDHKgLfQMkEmI/ldmUeWZbe', 'LECTURER', 'mptv'),
(36, '$2a$10$Nbh.jqB7FeonZyZ.mn5pd.t4uhK3JJNd7qQWWrY3D6QJAzGLc0LKG', 'LECTURER', 'mptvrv'),
(37, '$2a$10$EeUkC1Twu7CNsbGWB0GDyeSkL6b0fYZIx720XqKVxinIxuZ8JwodS', 'LECTURER', 'mptvv'),
(38, '$2a$10$MokBQR59zMVNhF2yF/.I5uv05C1VOnxA02CICUJysQSg8ASoj0ZeC', 'LECTURER', 'mpto'),
(39, '$2a$10$s1R12z/.fhIeypicknV9J.xpy6a2c83jJOrqSr0MGHf0J/8/VMjXC', 'LECTURER', 'mptooo'),
(40, '$2a$10$aKFB/TXxYrKrqVSbO7mYG.eHgAJtAXvJkfRYn56sLvxmJ4qQmzPSi', 'LECTURER', 'mptoo'),
(41, '$2a$10$/P2TE3HefhF57hSVEOMLEuTUGV6wlkQkOxChNxEKVfYCsnv9PZGDS', 'LECTURER', 'mptoto'),
(42, '$2a$10$COgQdRZNt9Zck8WanH4nLeVNJp4cOPV8SpwZRgUuLhj4A1E5dPrFi', 'LECTURER', 'mptot'),
(43, '$2a$10$T8ZnrFrk1OoxbO0nYIIyuuFqH.kVkWM8K3/DSlg9ReAtMHmNUfEUK', 'LECTURER', 'thanusan'),
(44, '$2a$10$j3Hufi7kJPvXpj3Eb8g8oOARqyyqedgEOAzaqFnM/aj.mgvn4LigC', 'ADMIN', 'thanusa'),
(45, '$2a$10$KmAM3PSjyFO6uuv0LEKxuu.gExAvwp4GDLqpotCXmwhPOjUnBD1n2', 'ADMIN', 'thanus'),
(46, '$2a$10$pYu51f.QwS5SjWW/mVBeo.B1Cb0.Y9Hf4srpl/VeAbEm5j21TfRJO', 'STUDENT', 'marimuthu'),
(47, '$2a$10$y8n.XWXI8jQpt34Fpfq.re4h11KIYzYdOvQtWQdvr0O.xzODOEVz2', 'STUDENT', 'anujan'),
(48, '$2a$10$v3VBWGdS0MImxnDSUPSyHOpRtqiQ65MIUzBD8lHIJGODLyeHXcJTm', 'STUDENT', 'anu'),
(49, '$2a$10$4G7HppvPzhHEaGjboqxw.uhavHmrwUhgWivx4SPkhIppPZ2gOOYoi', 'STUDENT', 'sapari'),
(50, '$2a$10$o/kKtvwYcOCJ5uFSol9sFOyuv4GWqg8JYj1EmTzawH1fQXLMFuCru', 'STUDENT', 'sapai'),
(51, '$2a$10$KqZPQab9czZ0Cn3sDwPx/OaCJDfbKLoyMpi7OE3RiZQyDhy7Moww.', 'STUDENT', 'sapa'),
(52, '$2a$10$UZTNeAQEZYWrgOqwfo0hHuyoXrYc.kv8u1GO80jhZ8SjpJZyz8kCi', 'LECTURER', 'sap'),
(53, '$2a$10$bpg9.y.rgTWiRovd4zSrd.9G6DMtonsXZl2wMnpzgoKBmVTjDn.OC', 'LECTURER', 's'),
(54, '$2a$10$nbhKCttiTF9XsPDr0KPqy.txAVAUQd.jT2jr87Viah/k66j/C/JKi', 'LECTURER', 'alaks'),
(55, '$2a$10$IXx9vYfYiZFMJzx8.FtiKeNth.WpnXwBj7eOl2cYxfmodFMjyg5FO', 'LECTURER', 'ala'),
(56, '$2a$10$tLqwJN4fAgXejUZEm4q6yeC.CjWtFFNAvRL32JbNbr6UlJt4f7oCS', 'LECTURER', 'alopio'),
(57, '$2a$10$Kbg87srj3bQITu.bLLssf.N04754fB0.jPPYub1efq/XjCwNAq64S', 'LECTURER', 'alopi'),
(58, '$2a$10$JAHdV/BWYTTw0ae0yDl0au1TVXF.ClM7bamOZS3GR2q/QbmptG/u2', 'LECTURER', 'alop'),
(59, '$2a$10$7.j/ej3cOFY6GYC7P4nIaeWdF6lHV1lFHuWTeeCa2XbfHXnomJcc2', 'LECTURER', 'alo'),
(60, '$2a$10$19YXDUqyuSsMIOZ1yBmlBudykNabRr2.KSJ3ldkCB1apSjb1t7wVi', 'USER', 'mahesvaran anujan'),
(61, '$2a$10$EQbutwfZrt2yCIP.UYR24OLtEG.LlUYU9ujL2LkxbGWmiJZwe..F.', 'USER', 'mahesvaran anujn'),
(62, '$2a$10$YcPgkK.E9APWZENEM9flj.in5DtCfNoKoeI4Q/eJQ2.hq4x8XkaEm', 'USER', 'mahesvaran anuj'),
(63, '$2a$10$IQXgZyOrd6qICp7phHMzVu.EIp6JAaB9TN87Fx6sI1bUnSgKIXIeS', 'ADMIN', 'vishnujan'),
(64, '$2a$10$UZSIVtL1ZmX0Cvw/qhZMs.SNSFATW.R6Fw8JE3iZwwjgjn.XHQ71K', 'ADMIN', 'givasakthi'),
(65, '$2a$10$2iwrrkLYVwEyErRXbyFc5ujcGj.VDMrcxL9A3CJrW7P2s3kTGr3gq', 'STUDENT', 'mauran'),
(66, '$2a$10$74ryCFM7Po6Vg6syfyfcg.X.zP1xQ43x9.AC1x3OEhcmIM.20JXW6', 'LECTURER', 'maur'),
(67, '$2a$10$TFbfCX6TLU4Di.WutGjUEOPZbLQv3sEN3B.dZuWLC3egMQ57J/.1O', 'USER', 'dbsdbsdb'),
(68, '$2a$10$W/puIKnnTQNTxJxfsR4R6OCysuUUKKnDv39mYSkxSzah.9M9A29H6', 'LECTURER', 'sajan'),
(69, '$2a$10$ddaEM1coYYFw7.CLVYCxtuA6xq6H89iXkJZcFcU0p2szMY70QJUEK', 'LECTURER', 'samDD');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `education_detail` varchar(255) NOT NULL,
  `fees_detail` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `personal_detail` varchar(255) NOT NULL,
  `login_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `education_detail`, `fees_detail`, `name`, `personal_detail`, `login_id`) VALUES
(1, 'colompo', '100.000.000', 'rajan', 'student', 46),
(3, 'cloumbo forgn studey', '100.000,000', 'arun', 'kilinochchi', 65);

-- --------------------------------------------------------

--
-- Table structure for table `student_course`
--

CREATE TABLE `student_course` (
  `id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_course`
--

INSERT INTO `student_course` (`id`, `course_id`, `student_id`) VALUES
(1, 1, 1),
(2, 1, 1),
(3, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `login_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `mobile`, `name`, `login_id`) VALUES
(1, 'saru@gmail.com', '0778283575', 'jan', 4),
(3, 'anujan@gmail.com', '0774387205', 'rathi', 10),
(4, 'anujan@gmail.com', '0774387205', 'rathi', 9),
(5, 'anujan@gmail.com', '0774387205', 'rathi', 11),
(6, 'alu@mail.com', '0774387259', 'ral', 20),
(7, 'alu@mail.com', '0774387259', 'ralo', 21),
(8, 'annujan@gmail.com', '0778283575', 'rakul', 60),
(9, 'annujan@gmail.com', '0778283575', 'rakul', 62),
(10, 'anujan@gmail.com', '0778283575', 'sajan', 67);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbv37acdlr0gn57xvbtbye6f5v` (`login_id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lecturers`
--
ALTER TABLE `lecturers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7kq8pbyeo4iffk05w6rc4m9yq` (`course_id`),
  ADD KEY `FKff6ixuhtnf99tx7gvylw2aaa1` (`login_id`);

--
-- Indexes for table `logins`
--
ALTER TABLE `logins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq2e324jsp4lk9buxk8tij1x4x` (`login_id`);

--
-- Indexes for table `student_course`
--
ALTER TABLE `student_course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpq6ovhxttt2ggd6cwu7sytpth` (`course_id`),
  ADD KEY `FKnh5bqghcqt8f5p2yqshbr5g6q` (`student_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr45vpxh8e24xrbqcul2k7rhfk` (`login_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `lecturers`
--
ALTER TABLE `lecturers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `logins`
--
ALTER TABLE `logins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student_course`
--
ALTER TABLE `student_course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
