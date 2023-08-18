package com.techelevator;

import com.techelevator.view.Menu;
import java.io.FileNotFoundException;
import java.io.IOException;


public class VendingMachineCLI {
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private Menu menu;

	public VendingMachineCLI(Menu menu) throws FileNotFoundException {
		this.menu = menu;
	}

	public void run() throws IOException {
		boolean running = true;
		Inventory inventory = new Inventory();
		inventory.readInventory();
		inventory.logo();
		Money money = new Money(0);
		TransactionLog log = new TransactionLog();

		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					// display vending machine items
					inventory.displayItems();
					break;
				case MAIN_MENU_OPTION_PURCHASE:
					// do purchase
					boolean userIsPurchasing = true;
					while (userIsPurchasing) {
						System.out.println("Current balance: $" + String.format("%.2f", money.getBalance()));
						String purchase = (String) menu.getChoiceFromOptions((PURCHASE_MENU_OPTIONS));


						switch (purchase) {
							case PURCHASE_MENU_OPTION_FEED_MONEY:
								double feedMoney = menu.requestMoney();
								if (!(feedMoney < 0) && !(feedMoney % 1 == 0)) {
									userIsPurchasing = false;
									System.out.println("Invalid amount. Please enter an amount in whole dollars.");
								} else {
									money.addBalance(feedMoney);
									log.log("Feed Money:", feedMoney, money.getBalance());
								}

								break;
							case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
								inventory.displayItems();
								String productCode = menu.selectProduct();
								inventory.purchaseItem(productCode, money, log);

								break;
							case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
								userIsPurchasing = false;
								System.out.println("Dispensing change.");
								money.change(log);
								break;
						}
					}
					break;
				case MAIN_MENU_OPTION_EXIT:
					System.out.println("Thank you for using this vending machine. Goodbye!");
					running = false;

					break;
				case MAIN_MENU_SECRET_OPTION:
//				print sales report
					inventory.salesLog();
					break;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
