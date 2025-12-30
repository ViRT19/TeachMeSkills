package ru.ksppoisk.shoppinglist.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.ksppoisk.shoppinglist.entities.NoteItem;
import ru.ksppoisk.shoppinglist.entities.ShopListItem;
import ru.ksppoisk.shoppinglist.entities.ShopListNameItem;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class Dao_Impl implements Dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NoteItem> __insertionAdapterOfNoteItem;

  private final EntityInsertionAdapter<ShopListItem> __insertionAdapterOfShopListItem;

  private final EntityInsertionAdapter<ShopListNameItem> __insertionAdapterOfShopListNameItem;

  private final EntityDeletionOrUpdateAdapter<NoteItem> __updateAdapterOfNoteItem;

  private final EntityDeletionOrUpdateAdapter<ShopListNameItem> __updateAdapterOfShopListNameItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteNote;

  private final SharedSQLiteStatement __preparedStmtOfDeleteShopListName;

  public Dao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNoteItem = new EntityInsertionAdapter<NoteItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `note_list` (`id`,`title`,`content`,`time`,`category`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NoteItem entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getContent() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContent());
        }
        if (entity.getTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTime());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCategory());
        }
      }
    };
    this.__insertionAdapterOfShopListItem = new EntityInsertionAdapter<ShopListItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `shop_list_item` (`id`,`name`,`itemInfo`,`itemChecked`,`listId`,`itemType`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ShopListItem entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getItemInfo() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getItemInfo());
        }
        statement.bindLong(4, entity.getItemChecked());
        statement.bindLong(5, entity.getListId());
        statement.bindLong(6, entity.getItemType());
      }
    };
    this.__insertionAdapterOfShopListNameItem = new EntityInsertionAdapter<ShopListNameItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `shopping_list_names` (`id`,`name`,`time`,`allItemCount`,`checkItemsCount`,`itemsIds`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ShopListNameItem entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTime());
        }
        statement.bindLong(4, entity.getAllItemCounter());
        statement.bindLong(5, entity.getCheckItemsCounter());
        if (entity.getItemIds() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getItemIds());
        }
      }
    };
    this.__updateAdapterOfNoteItem = new EntityDeletionOrUpdateAdapter<NoteItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `note_list` SET `id` = ?,`title` = ?,`content` = ?,`time` = ?,`category` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NoteItem entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getContent() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContent());
        }
        if (entity.getTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTime());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCategory());
        }
        if (entity.getId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getId());
        }
      }
    };
    this.__updateAdapterOfShopListNameItem = new EntityDeletionOrUpdateAdapter<ShopListNameItem>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `shopping_list_names` SET `id` = ?,`name` = ?,`time` = ?,`allItemCount` = ?,`checkItemsCount` = ?,`itemsIds` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ShopListNameItem entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTime());
        }
        statement.bindLong(4, entity.getAllItemCounter());
        statement.bindLong(5, entity.getCheckItemsCounter());
        if (entity.getItemIds() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getItemIds());
        }
        if (entity.getId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteNote = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM note_list WHERE id IS ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteShopListName = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM shopping_list_names WHERE id IS ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertNote(final NoteItem note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNoteItem.insert(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertItem(final ShopListItem shopListItem,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfShopListItem.insert(shopListItem);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertShopListName(final ShopListNameItem name,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfShopListNameItem.insert(name);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNote(final NoteItem note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNoteItem.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateListName(final ShopListNameItem shopListName,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfShopListNameItem.handle(shopListName);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNote(final int id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNote.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteNote.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteShopListName(final int id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteShopListName.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteShopListName.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<NoteItem>> getAllNotes() {
    final String _sql = "SELECT * FROM note_list";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"note_list"}, new Callable<List<NoteItem>>() {
      @Override
      @NonNull
      public List<NoteItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final List<NoteItem> _result = new ArrayList<NoteItem>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NoteItem _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _item = new NoteItem(_tmpId,_tmpTitle,_tmpContent,_tmpTime,_tmpCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ShopListNameItem>> getAllShopListNames() {
    final String _sql = "SELECT * FROM shopping_list_names";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"shopping_list_names"}, new Callable<List<ShopListNameItem>>() {
      @Override
      @NonNull
      public List<ShopListNameItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfAllItemCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "allItemCount");
          final int _cursorIndexOfCheckItemsCounter = CursorUtil.getColumnIndexOrThrow(_cursor, "checkItemsCount");
          final int _cursorIndexOfItemIds = CursorUtil.getColumnIndexOrThrow(_cursor, "itemsIds");
          final List<ShopListNameItem> _result = new ArrayList<ShopListNameItem>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ShopListNameItem _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final int _tmpAllItemCounter;
            _tmpAllItemCounter = _cursor.getInt(_cursorIndexOfAllItemCounter);
            final int _tmpCheckItemsCounter;
            _tmpCheckItemsCounter = _cursor.getInt(_cursorIndexOfCheckItemsCounter);
            final String _tmpItemIds;
            if (_cursor.isNull(_cursorIndexOfItemIds)) {
              _tmpItemIds = null;
            } else {
              _tmpItemIds = _cursor.getString(_cursorIndexOfItemIds);
            }
            _item = new ShopListNameItem(_tmpId,_tmpName,_tmpTime,_tmpAllItemCounter,_tmpCheckItemsCounter,_tmpItemIds);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
