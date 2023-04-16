package com.codegym.feature;

public class BannerApp {
    public static void menuBanner(String option) {
        if (option.equals("Product-ViewMenu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                          QUẢN LÝ SẢN PHẨM                                            ");
            System.out.println("                    【1】Thêm sản phẩm                         【4】Tìm kiếm sản phẩm                           ");
            System.out.println("                    【2】Cập nhật sản phẩm                     【5】Sắp xếp sản phẩm                             ");
            System.out.println("                    【3】Xoá sản phẩm                          【6】Hiển thị danh sách sản phẩm                    ");
            System.out.println("                    【0】Thoát                                 【7】Trở về                         ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("Sort-Product-Menu")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                SẮP XẾP SẢN PHẨM                                                      ");
            System.out.println("                         【1】Sắp xếp theo giá                                           ");
            System.out.println("                         【R】Trở về                                                  ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("Searching-Product")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                TÌM KIẾM SẢN PHẨM                                                     ");
            System.out.println("                         【1】Tìm kiếm theo ID sản phẩm              【2】Tìm kiếm theo tên                              ");
            System.out.println("                         【R】Trở về                                                                                   ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("Product-Service")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                THÊM SẢN PHẨM                                                 ");
            System.out.println("                         【1】Tên sản phẩm                        【3】Số lượng sản phẩm                    ");
            System.out.println("                         【2】Giá sản phẩm                       【4】ID Danh mục sản phẩm                          ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("Update-product")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                CẬP NHẬT SẢN PHẨM                                                     ");
            System.out.println("                         【1】Tên sản phẩm                          【3】Giá sản phẩm                              ");
            System.out.println("                         【2】Số lượng sản phẩm                     【R】Trở về                                  ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("Sort-by-price")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                SẮP XẾP SẢN PHẨM                                                    ");
            System.out.println("                         【1】Theo thứ tự tăng dần                      【2】Theo thứ tự giảm dần                   ");
            System.out.println("                         【R】Trở về                                                         ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("OrderView")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                     QUẢN LÝ ĐƠN HÀNG                                        ");
            System.out.println("              【1】Chi tiết đơn hàng                  【2】Thêm mới đơn hàng         ");
            System.out.println("              【3】Chỉnh sửa đơn hàng                 【4】Tìm kiếm đơn hàng theo tình trạng  ");
            System.out.println("              【5】Hiển thị tất cả đơn hàng           【6】Xoá đơn hàng                ");
            System.out.println("              【7】Hiển thị doanh thu                 【0】Thoát ");
            System.out.println("              【R】Trở về       ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("Update-Order-View")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                                CẬP NHẬT ĐƠN HÀNG                                                    ");
            System.out.println("                         【1】Ngày đặt hàng                                【2】Trạng thái đơn hàng                   ");
            System.out.println("                                                      【R】Trở về                 ");
            System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("Search-Order-Status-View")) {
            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                        TÌM KIẾM ĐƠN HÀNG BẰNG TÌNH TRẠNG                                                    ");
            System.out.println("                         【1】Chờ xác nhận                                 【2】Đã thanh toán                   ");
            System.out.println("                         【3】Chưa thanh toán                              【4】Đã huỷ                   ");
            System.out.println("                         【R】Trở về                   ");
            System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("LoginView")){
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                           CHÀO MỪNG ĐẾN VỚI THẾ GIỚI THỜI TRANG CAO CẤP                                        ");
            System.out.println("                                        【1】Admin                                    ");
            System.out.println("                                        【2】Khách hàng                                         ");
            System.out.println("                                        【3】Thoát                                                   ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("Admin-Menu-View")) {
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                          TRANG QUẢN LÝ                          ");
            System.out.println("                       【1】Quản lý sản phẩm                                        ");
            System.out.println("                       【2】Quản lý đơn hàng                                       ");
            System.out.println("                       【3】Quản lý khách hàng                                     ");
            System.out.println("            【0】Thoát                     【4】Trở về ");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("set-role")) {
            System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                                   ĐẶT LẠI VAI TRÒ NGƯỜI DÙNG                                         ");
            System.out.println("                                        【1】Khách hàng                                   ");
            System.out.println("                                        【2】Admin                                         ");
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("List-User")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                            QUẢN LÝ KHÁCH HÀNG                                ");
            System.out.println("                         【1】Hiển thị tất cả khách hàng                                        ");
            System.out.println("                         【2】Thêm khách hàng                                       ");
            System.out.println("                         【3】Chỉnh sửa thông tin khách hàng                                     ");
            System.out.println("                         【4】Xoá khách hàng                                       ");
            System.out.println("                         【R】Trở về                                    ");
            System.out.println("                         【0】Thoát "                              );
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("Update-UserView")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                    CHỈNH SỬA THÔNG TIN KHÁCH HÀNG                     ");
            System.out.println("                         【1】Tên                                        ");
            System.out.println("                         【2】Số điện thoại                                       ");
            System.out.println("                         【3】Địa chỉ                                     ");
            System.out.println("                         【4】Email                                       ");
            System.out.println("                         【5】Tất cả thông tin                                    ");
            System.out.println("                         【6】Trở về                                    ");
            System.out.println("                         【0】Thoát        ");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("userView")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                          TRANG NGƯỜI DÙNG                ");
            System.out.println("      【1】Hiển thị tất cả sản phẩm       【3】Sắp xếp sản phẩm                    ");
            System.out.println("      【2】Đặt hàng                       【4】Tìm kiếm sản phẩm                   ");
            System.out.println("      【0】Thoát                                 ");
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
        if (option.equals("profitMenu")) {
            System.out.println("╔═════════════════════════════════════════════════════════════════╗");
            System.out.println("                             DOANH THU                     ");
            System.out.println("  【1】Doanh thu theo ngày               【2】Doanh thu theo tháng                    ");
            System.out.println("                            【R】Trở về                                           " );
            System.out.println("╚═════════════════════════════════════════════════════════════════╝");
            System.out.println("➔ Chọn chức năng:");
        }
    }


}