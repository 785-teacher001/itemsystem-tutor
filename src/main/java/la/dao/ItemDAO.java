package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ItemBean;

public class ItemDAO {

	/**
	 * コンストラクタ：JDBCコンストラクタを読込む
	 * @throws DAOException
	 */
	public ItemDAO() throws DAOException {
		try {
			Class.forName(DbInfo.JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// スタックトレースに表示
			e.printStackTrace();
			// DAO例外をスロー
			throw new DAOException("JDBCドライバの取得に失敗しました。");
		}
	}

	/**
	 * すべての商品を取得する
	 * @return 商品リスト
	 * @throws DAOException
	 */
	public List<ItemBean> findAll() throws DAOException {
		// 1. 実行するSQLを設定
		String sql = "SELECT * FROM item ORDER BY code";
		try (
			// 2. データベース接続オブジェクトを取得
			Connection con = DriverManager.getConnection(DbInfo.DB_URL, DbInfo.DB_USER, DbInfo.DB_PASSWORD);
			// 3. SQL実行オブジェクトを取得
			PreparedStatement pstmt = con.prepareStatement(sql);
			// 4. SQLの実行と結果セットの取得
			ResultSet rs = pstmt.executeQuery();
			) {
			// 5. 結果セットを商品リストに変換
			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				int code = rs.getInt("code");
				int categoryCode = rs.getInt("category_code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(code, categoryCode, name, price);
				list.add(bean);
			}
			// 6. 商品リストを返却
			return list;
		} catch (SQLException e) {
			// スタックトレースに表示
			e.printStackTrace();
			// DAO例外をスロー
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	
}
