package ru.ksppoisk.shoppinglist.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MainDataBase_Impl extends MainDataBase {
  private volatile Dao _dao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `library` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `note_list` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `time` TEXT NOT NULL, `category` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `shop_list_item` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `itemInfo` TEXT, `itemChecked` INTEGER NOT NULL, `listId` INTEGER NOT NULL, `itemType` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `shopping_list_names` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `time` TEXT NOT NULL, `allItemCount` INTEGER NOT NULL, `checkItemsCount` INTEGER NOT NULL, `itemsIds` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fb178b979d96919cdb122db42709e0f9')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `library`");
        db.execSQL("DROP TABLE IF EXISTS `note_list`");
        db.execSQL("DROP TABLE IF EXISTS `shop_list_item`");
        db.execSQL("DROP TABLE IF EXISTS `shopping_list_names`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsLibrary = new HashMap<String, TableInfo.Column>(2);
        _columnsLibrary.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLibrary.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLibrary = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLibrary = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLibrary = new TableInfo("library", _columnsLibrary, _foreignKeysLibrary, _indicesLibrary);
        final TableInfo _existingLibrary = TableInfo.read(db, "library");
        if (!_infoLibrary.equals(_existingLibrary)) {
          return new RoomOpenHelper.ValidationResult(false, "library(ru.ksppoisk.shoppinglist.entities.LibraryItem).\n"
                  + " Expected:\n" + _infoLibrary + "\n"
                  + " Found:\n" + _existingLibrary);
        }
        final HashMap<String, TableInfo.Column> _columnsNoteList = new HashMap<String, TableInfo.Column>(5);
        _columnsNoteList.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteList.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteList.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteList.put("time", new TableInfo.Column("time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNoteList.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNoteList = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNoteList = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNoteList = new TableInfo("note_list", _columnsNoteList, _foreignKeysNoteList, _indicesNoteList);
        final TableInfo _existingNoteList = TableInfo.read(db, "note_list");
        if (!_infoNoteList.equals(_existingNoteList)) {
          return new RoomOpenHelper.ValidationResult(false, "note_list(ru.ksppoisk.shoppinglist.entities.NoteItem).\n"
                  + " Expected:\n" + _infoNoteList + "\n"
                  + " Found:\n" + _existingNoteList);
        }
        final HashMap<String, TableInfo.Column> _columnsShopListItem = new HashMap<String, TableInfo.Column>(6);
        _columnsShopListItem.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShopListItem.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShopListItem.put("itemInfo", new TableInfo.Column("itemInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShopListItem.put("itemChecked", new TableInfo.Column("itemChecked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShopListItem.put("listId", new TableInfo.Column("listId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShopListItem.put("itemType", new TableInfo.Column("itemType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysShopListItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesShopListItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoShopListItem = new TableInfo("shop_list_item", _columnsShopListItem, _foreignKeysShopListItem, _indicesShopListItem);
        final TableInfo _existingShopListItem = TableInfo.read(db, "shop_list_item");
        if (!_infoShopListItem.equals(_existingShopListItem)) {
          return new RoomOpenHelper.ValidationResult(false, "shop_list_item(ru.ksppoisk.shoppinglist.entities.ShoppingListItem).\n"
                  + " Expected:\n" + _infoShopListItem + "\n"
                  + " Found:\n" + _existingShopListItem);
        }
        final HashMap<String, TableInfo.Column> _columnsShoppingListNames = new HashMap<String, TableInfo.Column>(6);
        _columnsShoppingListNames.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingListNames.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingListNames.put("time", new TableInfo.Column("time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingListNames.put("allItemCount", new TableInfo.Column("allItemCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingListNames.put("checkItemsCount", new TableInfo.Column("checkItemsCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShoppingListNames.put("itemsIds", new TableInfo.Column("itemsIds", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysShoppingListNames = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesShoppingListNames = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoShoppingListNames = new TableInfo("shopping_list_names", _columnsShoppingListNames, _foreignKeysShoppingListNames, _indicesShoppingListNames);
        final TableInfo _existingShoppingListNames = TableInfo.read(db, "shopping_list_names");
        if (!_infoShoppingListNames.equals(_existingShoppingListNames)) {
          return new RoomOpenHelper.ValidationResult(false, "shopping_list_names(ru.ksppoisk.shoppinglist.entities.ShoppingListNames).\n"
                  + " Expected:\n" + _infoShoppingListNames + "\n"
                  + " Found:\n" + _existingShoppingListNames);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fb178b979d96919cdb122db42709e0f9", "c53e2af9766bc245ccc61c37f15d226a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "library","note_list","shop_list_item","shopping_list_names");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `library`");
      _db.execSQL("DELETE FROM `note_list`");
      _db.execSQL("DELETE FROM `shop_list_item`");
      _db.execSQL("DELETE FROM `shopping_list_names`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(Dao.class, Dao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public Dao getDao() {
    if (_dao != null) {
      return _dao;
    } else {
      synchronized(this) {
        if(_dao == null) {
          _dao = new Dao_Impl(this);
        }
        return _dao;
      }
    }
  }
}
