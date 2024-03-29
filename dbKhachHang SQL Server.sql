USE [master]
GO
/****** Object:  Database [dbKhachHang]    Script Date: 7/21/2021 4:16:02 PM ******/
CREATE DATABASE [dbKhachHang]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'dbKhachHang', FILENAME = N'D:\Download program\DataSql\Bai 1\dbKhachHang.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'dbKhachHang_log', FILENAME = N'D:\Download program\DataSql\Bai 1\dbKhachHang_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [dbKhachHang] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbKhachHang].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbKhachHang] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbKhachHang] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbKhachHang] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbKhachHang] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbKhachHang] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbKhachHang] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbKhachHang] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbKhachHang] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbKhachHang] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbKhachHang] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbKhachHang] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbKhachHang] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbKhachHang] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbKhachHang] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbKhachHang] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dbKhachHang] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbKhachHang] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbKhachHang] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbKhachHang] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbKhachHang] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbKhachHang] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbKhachHang] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbKhachHang] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [dbKhachHang] SET  MULTI_USER 
GO
ALTER DATABASE [dbKhachHang] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbKhachHang] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbKhachHang] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbKhachHang] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [dbKhachHang] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [dbKhachHang] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [dbKhachHang] SET QUERY_STORE = OFF
GO
USE [dbKhachHang]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 7/21/2021 4:16:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](50) NOT NULL,
	[TenKH] [nvarchar](250) NULL,
	[NamSinh] [int] NULL,
	[MaNhom] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nhom]    Script Date: 7/21/2021 4:16:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nhom](
	[MaNhom] [nvarchar](50) NOT NULL,
	[TenNhom] [nvarchar](250) NULL,
 CONSTRAINT [PK_Nhom] PRIMARY KEY CLUSTERED 
(
	[MaNhom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [NamSinh], [MaNhom]) VALUES (N'kh1', N'Vinh', 2000, N'mn3')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [NamSinh], [MaNhom]) VALUES (N'kh2', N'Ly', 1998, N'mn2')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [NamSinh], [MaNhom]) VALUES (N'kh3', N'Tít', 1995, N'mn1')
GO
INSERT [dbo].[Nhom] ([MaNhom], [TenNhom]) VALUES (N'mn1', N'Nhóm khách hàng vip')
INSERT [dbo].[Nhom] ([MaNhom], [TenNhom]) VALUES (N'mn2', N'Nhóm khách hàng tiềm năng')
INSERT [dbo].[Nhom] ([MaNhom], [TenNhom]) VALUES (N'mn3', N'Nhóm khách hàng mới')
GO
/****** Object:  StoredProcedure [dbo].[LayKhachHangTheoNhom]    Script Date: 7/21/2021 4:16:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[LayKhachHangTheoNhom]
@manhom nvarchar(50)
as
select * from KhachHang where MaNhom = @manhom
GO
/****** Object:  StoredProcedure [dbo].[LayToanBoKhachHang]    Script Date: 7/21/2021 4:16:02 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[LayToanBoKhachHang]
as
select * from KhachHang
GO
USE [master]
GO
ALTER DATABASE [dbKhachHang] SET  READ_WRITE 
GO
