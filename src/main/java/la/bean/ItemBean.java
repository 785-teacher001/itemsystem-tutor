package la.bean;

public class ItemBean {
	
	/**
	 * フィールド
	 */
	private int code;         // 商品番号
	private int categoryCode; // カテゴリコード
	private String name;      // 商品名
	private int price;        // 価格
	
	/**
	 * 引数なしコンストラクタ
	 */
	public ItemBean() {}

	/**
	 * コンストラクタ
	 * @param code         商品番号
	 * @param categoryCode カテゴリコード
	 * @param name         商品名
	 * @param price        価格
	 */
	public ItemBean(int code, int categoryCode, String name, int price) {
		this.code = code;
		this.categoryCode = categoryCode;
		this.name = name;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
