-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Jan 2020 pada 06.02
-- Versi server: 10.3.15-MariaDB
-- Versi PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cafe_anomali`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `daftarkopi`
--

CREATE TABLE `daftarkopi` (
  `id_kopi` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `pengirim` varchar(30) NOT NULL,
  `penerima` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `daftarkopi`
--

INSERT INTO `daftarkopi` (`id_kopi`, `nama`, `pengirim`, `penerima`, `alamat`) VALUES
(690456, 'kopi robusta', 'PT aneka nusantara', 'coffe anomali', 'pandaan-pasuruan'),
(690460, 'kopi bengkulu', 'PT pulau hitam', 'coffe anomali', 'pandaan-pasuruan'),
(690420, 'kopi vietnam drip', 'pt suaka raya', 'cafe anomali', 'pandaan-pasuruan');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
