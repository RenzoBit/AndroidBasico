package pe.edu.tecsup.androidsesion4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Renzo on 26/07/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

	public DbHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public DbHelper(Context context) {
		super(context, "municipalidad.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE IF NOT EXISTS cuenta (id INTEGER PRIMARY KEY AUTOINCREMENT, correo TEXT NOT NULL, clave TEXT NOT NULL)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS cuenta");
		onCreate(db);
	}

}
