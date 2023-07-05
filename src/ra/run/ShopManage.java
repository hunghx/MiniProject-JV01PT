package ra.run;

import ra.config.InputMethods;
import ra.controller.CatalogController;
import ra.model.Catalog;

public class ShopManage {
    private static CatalogController catalogController = new CatalogController();
    public static void main(String[] args) {
        while (true){
            System.out.println("----------------Menu--------------  \n" +
                    "1. Quản lí danh mục\n" +
                    "2. QUản lí sản phẩm \n" +
                    "3. Thoát");
            int choice = InputMethods.getInteger();
            switch (choice){
                case 1:
                    // menu danh mục
                    menuCatalog();
                    break;
                    case 2:
                    // menu sp
                        menuProduct();
                    break;
                    case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui long nhập 1-3");
            }
        }
    }
    public static void menuCatalog(){
        while (true){
            System.out.println("----------------Menu--------------  \n" +
                    "1. Hiển thị danh sách danh mục\n" +
                    "2. Thêm mới danh mục\n" +
                    "3. Chỉnh sửa thông tin danh mục\n" +
                    "4. Xóa danh mục (trạng thái  true -> false)\n" +
                    "5. Quay lại menu chính ");
            int choice = InputMethods.getInteger();
            switch (choice){
                case 1:
                    //hiển thị danh mục
                    displayCatalog();
                    break;
                case 2:
                    // them mới
                    createNewCatalog();
                    break;
                case 3:
                    // chinhr sửa
                    updateCatalog();
                    break;
                case 4:
                    // xóa
                    break;
                case 5:
                    // quay lại
                    break;
                default:
                    System.err.println("Vui long nhập 1-3");
            }
            if(choice == 5){
                break;
            }
        }
    }
    // hiênr thi
    public static void displayCatalog(){
        if(catalogController.findAll().isEmpty()){
            System.err.println("Danh sách danh mục trống");
            return;
        }
        for (Catalog cat :catalogController.findAll()) {
            System.out.println(cat);
        }
    }
    // thêm mới
    public static void createNewCatalog(){
        Catalog newCatalog = new Catalog();
        int idNew = catalogController.getNewId();
        System.out.println("Id : "+idNew);
        newCatalog.setId(idNew);
        System.out.println("Nhập tên danh mục");
        newCatalog.setName(InputMethods.getString());
        catalogController.save(newCatalog);
        System.out.println("thêm mới thành công");
    }
    public static void updateCatalog(){
        System.out.println("Nhập id danh mục cần chỉnh sưa");
        int catId = InputMethods.getInteger();
        Catalog catEdit = catalogController.findById(catId);
        if(catEdit==null){
            // ko tồn tại
            System.err.println("không tìm thấy id");
            return;
        }
        // cho phep sưar thông
        System.out.println("nhập tên mới cho danh mục này , tên cũ là : "+catEdit.getName());
        catEdit.setName(InputMethods.getString());
        catalogController.save(catEdit);
        System.out.println("Cập nhật thành công");
    }
    public static void menuProduct(){

    }
}
