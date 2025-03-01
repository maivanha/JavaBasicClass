package javaCore.oopExample;

class DongVat {
    // Các thuộc tính chung
    public String ten;
    public int tuoiHienTai;

    // Constructor của lớp cha sẽ không khởi tạo các trường final
    public DongVat(String ten, int tuoiHienTai) {
        this.ten = ten;
        this.tuoiHienTai = tuoiHienTai;
    }

    // Phương thức thongTin: Trả về thông tin của đối tượng
    public String thongTin() {
        return "Tên: " + ten + ", Tuổi hiện tại: " + tuoiHienTai + ", Loài: " + getLoai() + 
               ", Tuổi trung bình: " + getTuoiTrungBinh() + ", Môi trường sống: " + getMoiTruongSong();
    }

    // Phương thức so sánh tuổi của hai con cùng loài
    public boolean soSanhTuoi(DongVat dv) {
        return this.getLoai().equals(dv.getLoai()) && this.tuoiHienTai == dv.tuoiHienTai;
    }

    // Phương thức so sánh tuổi của hai con khác loài
    public String soSanhTuoiKhacLoai(DongVat dv) {
        if (!this.getLoai().equals(dv.getLoai())) {
            //return "Chênh lệch tuổi: " + (this.tuoiHienTai - dv.tuoiHienTai) + " năm.";
            return "Ket qua so sanh: " + this.ten + ((this.tuoiHienTai - dv.tuoiHienTai > 0)? "Gia hon" : "Tre hon") + dv.ten;
        } else {
        	return "Ket qua so sanh: " + this.ten + ((this.tuoiHienTai * dv.getTuoiTrungBinh() - dv.tuoiHienTai * this.getTuoiTrungBinh() > 0)? "Gia hon" : "Tre hon") + dv.ten;
        }
    }

    // Phương thức trả về loài động vật
    public String getLoai() {
        return "Không xác định";
    }

    // Phương thức trả về tuổi trung bình của loài
    public int getTuoiTrungBinh() {
        return 0;
    }

    // Phương thức trả về môi trường sống của loài
    public String getMoiTruongSong() {
        return "Không xác định";
    }

    // Phương thức in thông tin của đối tượng
    public static void inThongTin(DongVat dv) {
        System.out.println(dv.thongTin());
    }

    public static void main(String[] args) {
        // Tạo các đối tượng
        Cho cho1 = new Cho("Chó A", 5);
        Cho cho2 = new Cho("Chó B", 5);
        
        Meo meo1 = new Meo("Mèo A", 3);
        Meo meo2 = new Meo("Mèo B", 4);
        
        Ca ca1 = new Ca("Cá A", 2);
        Ca ca2 = new Ca("Cá B", 5);

        // In thông tin
        System.out.println("Thông tin các động vật:");
        inThongTin(cho1);
        inThongTin(meo1);
        inThongTin(ca1);

        // So sánh tuổi của hai con cùng loài (Chó A và Chó B)
        System.out.println("\nSo sánh tuổi của hai con Chó:");
        System.out.println(cho1.soSanhTuoi(cho2) ? "Hai con chó có tuổi giống nhau." : "Hai con chó có tuổi khác nhau.");

        // So sánh tuổi của chó và mèo
        System.out.println("\nSo sánh tuổi của Chó A và Mèo A:");
        System.out.println(cho1.soSanhTuoiKhacLoai(meo1));

        // So sánh tuổi của mèo và cá
        System.out.println("\nSo sánh tuổi của Mèo A và Cá A:");
        System.out.println(meo1.soSanhTuoiKhacLoai(ca1));
    }
}


// Lớp Chó
class Cho extends DongVat {
    public static final String loai = "Chó";
    public static final int tuoiTrungBinh = 12;
    public static final String moiTruongSong = "Cảnh quan đất liền";

    public Cho(String ten, int tuoiHienTai) {
        super(ten, tuoiHienTai);
    }

    @Override
    public String getLoai() {
        return loai;
    }

    @Override
    public int getTuoiTrungBinh() {
        return tuoiTrungBinh;
    }

    @Override
    public String getMoiTruongSong() {
        return moiTruongSong;
    }
}

// Lớp Mèo
class Meo extends DongVat {
    public static final String loai = "Mèo";
    public static final int tuoiTrungBinh = 15;
    public static final String moiTruongSong = "Cảnh quan đất liền";

    public Meo(String ten, int tuoiHienTai) {
        super(ten, tuoiHienTai);
    }

    @Override
    public String getLoai() {
        return loai;
    }

    @Override
    public int getTuoiTrungBinh() {
        return tuoiTrungBinh;
    }

    @Override
    public String getMoiTruongSong() {
        return moiTruongSong;
    }
}

// Lớp Cá
class Ca extends DongVat {
    public static final String loai = "Cá";
    public static final int tuoiTrungBinh = 10;
    public static final String moiTruongSong = "Nước";

    public Ca(String ten, int tuoiHienTai) {
        super(ten, tuoiHienTai);
    }

    @Override
    public String getLoai() {
        return loai;
    }

    @Override
    public int getTuoiTrungBinh() {
        return tuoiTrungBinh;
    }

    @Override
    public String getMoiTruongSong() {
        return moiTruongSong;
    }
}
