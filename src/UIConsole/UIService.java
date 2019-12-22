package UIConsole;

import Database.Category;
import Service.ProductException;
import Service.ProductService;
import java.math.BigDecimal;
import java.util.Scanner;

public class UIService {
    public static void main(String[] args) throws ProductException {
        System.out.println("Welcome!");
        System.out.println("===================");
        UIService ui = new UIService();
        ui.menu();
    }

    Scanner uiService = new Scanner(System.in);
    ProductService ps = new ProductService();
    String input;
    int command;

    public void menu() throws ProductException {
        System.out.println("Product accounting system");
        System.out.println();
        System.out.println("[0] Add new product");
        System.out.println("[1] Set category discount");
        System.out.println("[2] List all products");
        System.out.println("[3] List all categories");
        System.out.println("[4] Find by ID");
        System.out.println("[5] Update price");
        System.out.println("[6] Update discount");
        System.out.println("[7] Update description");
        System.out.println("[8] Find by category");
        System.out.println("[9] Update category");
        System.out.println("[10] Delete by ID");
        System.out.println("[11] Update Name");
        System.out.println("[12] Exit");
        System.out.println();
        System.out.println("Enter command 0 - 12 :");
        input = uiService.nextLine();
        command = Integer.parseInt(input);
        switch (command) {
            case 1:
                uiSetCategoryDiscount();
                break;
            case 2:
                uiFindAll();
                break;
            case 3:
                uiListCategory();
                break;
            case 4:
                uiFindById();
                break;
            case 5:
                uiUpdatePrice();
                break;
            case 6:
                uiUpdateDiscount();
                break;
            case 7:
                uiUpdateDescription();
                break;
            case 8:
                uiFindByCategory();
                break;
            case 9:
                uiUpdateCategory();
                break;
            case 0:
                uiAddNewProduct();
                break;
            case 10:
                uiDeleteById();
                break;
            case 11:
                uiUpdateName();
                break;
            case 12:
                uiExit();
                break;
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiListCategory() throws ProductException {
        if (command == 3) {
            System.out.println(ps.listCategories());
            System.out.println("===================");
            menu();
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiFindAll() throws ProductException {
        if (command == 2) {
            System.out.println(ps.findAll());
            System.out.println("===================");
            menu();
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiAddNewProduct() throws ProductException {
        if (command == 0) {
            System.out.println("Select category ");
            System.out.println("[1] Fruits");
            System.out.println("[2] Vegetables");
            System.out.println("[3] Drinks");
            System.out.println("[4] Meat");
            System.out.println("[5] Fish");
            System.out.println("[6] Milk");
            input = uiService.nextLine();
            command = Integer.parseInt(input);
            if (command > 6 || command < 0) {
                System.out.println("Wrong command");
                System.out.println("===================");
                menu();
            } else {
                Category category = null;
                switch (command) {
                    case 1:
                        category = Category.FRUITS;
                        break;
                    case 2:
                        category = Category.VEGETABLES;
                        break;
                    case 3:
                        category = Category.DRINKS;
                        break;
                    case 4:
                        category = Category.MEAT;
                        break;
                    case 5:
                        category = Category.FISH;
                        break;
                    case 6:
                        category = Category.MILK;
                        break;
                }
                System.out.println("Enter name:");
                String name = uiService.nextLine();
                System.out.println("Enter price");
                BigDecimal price = new BigDecimal(uiService.nextLine());
                System.out.println("Enter discount:");
                BigDecimal discount = new BigDecimal(uiService.nextLine());
                System.out.println("Enter description:");
                String description = uiService.nextLine();
                ps.addNewProduct(name, price, category, discount, description);
                System.out.println("Product added!");
                System.out.println("===================");
                menu();
            }
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiFindById() throws ProductException {
        if (command == 4) {
            System.out.println("Enter product ID:");
            input = uiService.nextLine();
            int id = Integer.parseInt(input);
            System.out.println(ps.findById(id));
            System.out.println("===================");
            menu();
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiUpdatePrice() throws ProductException {
        if (command == 5) {
            System.out.println("Enter product ID:");
            input = uiService.nextLine();
            int id = Integer.parseInt(input);
            System.out.println("Enter new price:");
            input = uiService.nextLine();
            BigDecimal price = new BigDecimal(input);
            ps.updatePrice(id, price);
            System.out.println("Product price updated!");
            System.out.println("===================");
            menu();
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiUpdateDiscount() throws ProductException {
        if (command == 6) {
            System.out.println("Enter product ID:");
            input = uiService.nextLine();
            int id = Integer.parseInt(input);
            System.out.println("Enter new discount:");
            input = uiService.nextLine();
            BigDecimal discount = new BigDecimal(input);
            ps.updateDiscount(id, discount);
            System.out.println("Product discount updated!");
            System.out.println("===================");
            menu();
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiUpdateDescription() throws ProductException {
        if (command == 7) {
            System.out.println("Enter product ID:");
            input = uiService.nextLine();
            int id = Integer.parseInt(input);
            System.out.println("Enter new description:");
            String description = uiService.nextLine();
            ps.updateDescription(id, description);
            System.out.println("Product description updated!");
            System.out.println("===================");
            menu();
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiFindByCategory() throws ProductException {
        if (command == 8) {
            System.out.println("Select category ");
            System.out.println("[1] Fruits");
            System.out.println("[2] Vegetables");
            System.out.println("[3] Drinks");
            System.out.println("[4] Meat");
            System.out.println("[5] Fish");
            System.out.println("[6] Milk");
            input = uiService.nextLine();
            command = Integer.parseInt(input);
            Category category = null;
            if (command > 6 || command < 0) {
                System.out.println("Wrong command");
                System.out.println("===================");
                menu();
            } else {
                switch (command) {
                    case 1:
                        category = Category.FRUITS;
                        break;
                    case 2:
                        category = Category.VEGETABLES;
                        break;
                    case 3:
                        category = Category.DRINKS;
                        break;
                    case 4:
                        category = Category.MEAT;
                        break;
                    case 5:
                        category = Category.FISH;
                        break;
                    case 6:
                        category = Category.MILK;
                        break;
                }
                System.out.println(ps.findByCategory(category));
                System.out.println("===================");
                menu();
            }
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiUpdateCategory() throws ProductException {
        if (command == 9) {
            System.out.println("Enter product ID:");
            input = uiService.nextLine();
            int id = Integer.parseInt(input);
            System.out.println("Select category ");
            System.out.println("[1] Fruits");
            System.out.println("[2] Vegetables");
            System.out.println("[3] Drinks");
            System.out.println("[4] Meat");
            System.out.println("[5] Fish");
            System.out.println("[6] Milk");
            input = uiService.nextLine();
            command = Integer.parseInt(input);
            Category category = null;
            if (command > 6 || command < 0) {
                System.out.println("Wrong command");
                System.out.println("===================");
                menu();
            } else {
                switch (command) {
                    case 1:
                        category = Category.FRUITS;
                        break;
                    case 2:
                        category = Category.VEGETABLES;
                        break;
                    case 3:
                        category = Category.DRINKS;
                        break;
                    case 4:
                        category = Category.MEAT;
                        break;
                    case 5:
                        category = Category.FISH;
                        break;
                    case 6:
                        category = Category.MILK;
                        break;
                }
                ps.updateCategory(id, category);
                System.out.println("Category updated!");
                System.out.println("===================");
                menu();
            }
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiSetCategoryDiscount() throws ProductException {
        if (command == 1) {
            System.out.println("Select category ");
            System.out.println("[1] Fruits");
            System.out.println("[2] Vegetables");
            System.out.println("[3] Drinks");
            System.out.println("[4] Meat");
            System.out.println("[5] Fish");
            System.out.println("[6] Milk");
            input = uiService.nextLine();
            command = Integer.parseInt(input);
            Category category = null;
            if (command > 6 || command < 0) {
                System.out.println("Wrong command");
                System.out.println("===================");
                menu();
            } else {
                switch (command) {
                    case 1:
                        category = Category.FRUITS;
                        break;
                    case 2:
                        category = Category.VEGETABLES;
                        break;
                    case 3:
                        category = Category.DRINKS;
                        break;
                    case 4:
                        category = Category.MEAT;
                        break;
                    case 5:
                        category = Category.FISH;
                        break;
                    case 6:
                        category = Category.MILK;
                        break;
                }
                System.out.println("Enter new discount:");
                input = uiService.nextLine();
                BigDecimal discount = new BigDecimal(input);
                ps.setCategoryDiscount(category, discount);
                System.out.println("Category discount updated!");
                System.out.println("===================");
                menu();
            }
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiDeleteById() throws ProductException {
        if (command == 10) {
            System.out.println("Enter product ID:");
            input = uiService.nextLine();
            int id = Integer.parseInt(input);
            ps.deleteById(id);
            System.out.println("Product has been removed!");
            System.out.println("===================");
            menu();
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiUpdateName() throws ProductException {
        if (command == 11) {
            System.out.println("Enter product ID:");
            input = uiService.nextLine();
            int id = Integer.parseInt(input);
            System.out.println("Enter new name:");
            String name = uiService.nextLine();
            ps.updateName(id, name);
            System.out.println("Product name updated!");
            System.out.println("===================");
            menu();
        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }

    public void uiExit() throws ProductException {
        if (command == 12) {
            System.out.println("Goodbye!");

        }
        if (command > 12 || command < 0) {
            System.out.println("Wrong command");
            System.out.println("===================");
            menu();
        }
    }
}

