package pe.edu.tecsup.androidsesion4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Renzo on 26/07/2016.
 */
public class CuentaDAO {

	private DbHelper _dbHelper;

	public CuentaDAO(Context c) {
		_dbHelper = new DbHelper(c);
	}

	public void insertar(String correo, String clave) throws DAOExcepcion {
		Log.i("CuentaDAO", "insert()");
		SQLiteDatabase db = _dbHelper.getWritableDatabase();
		try {
			String[] args = new String[]{correo, clave};
			db.execSQL("INSERT INTO cuenta(correo, clave) VALUES(?, ?)", args);
			Log.i("CuentaDAO", "Se insertó");
		} catch (Exception e) {
			throw new DAOExcepcion("CuentaDAO: Error al insertar: " + e.getMessage());
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	public Cuenta obtener() throws DAOExcepcion {
		Log.i("CuentaDAO", "obtener()");
		SQLiteDatabase db = _dbHelper.getReadableDatabase();
		Cuenta modelo = new Cuenta();
		try {
			Cursor c = db.rawQuery("select id, correo, clave from cuenta", null);
			if (c.getCount() > 0) {
				c.moveToFirst();
				do {
					int id = c.getInt(c.getColumnIndex("id"));
					String correo = c.getString(c.getColumnIndex("correo"));
					String clave = c.getString(c.getColumnIndex("clave"));
					modelo.setId(id);
					modelo.setCorreo(correo);
					modelo.setClave(clave);
				} while (c.moveToNext());
			}
			c.close();
		} catch (Exception e) {
			throw new DAOExcepcion("CuentaDAO: Error al obtener: " + e.getMessage());
		} finally {
			if (db != null) {
				db.close();
			}
		}
		return modelo;
	}

	public void eliminar(int id) throws DAOExcepcion {
		Log.i("CuentaDAO", "eliminar()");
		SQLiteDatabase db = _dbHelper.getWritableDatabase();
		try {
			String[] args = new String[]{String.valueOf(id)};
			db.execSQL("DELETE FROM cuenta WHERE id = ?", args);
		} catch (Exception e) {
			throw new DAOExcepcion("CuentaDAO: Error al eliminar: " + e.getMessage());
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

	public void eliminarTodos() throws DAOExcepcion {
		Log.i("CuentaDAO", "eliminarTodos()");
		SQLiteDatabase db = _dbHelper.getWritableDatabase();
		try {
			db.execSQL("DELETE FROM cuenta");
		} catch (Exception e) {
			throw new DAOExcepcion("CuentaDAO: Error al eliminar todos: " + e.getMessage());
		} finally {
			if (db != null) {
				db.close();
			}
		}
	}

}
