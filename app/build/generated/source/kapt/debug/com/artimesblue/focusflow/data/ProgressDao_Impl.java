package com.artimesblue.focusflow.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ProgressDao_Impl implements ProgressDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProgressEntry> __insertionAdapterOfProgressEntry;

  public ProgressDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProgressEntry = new EntityInsertionAdapter<ProgressEntry>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `progress_entries` (`id`,`habitId`,`date`,`amount`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ProgressEntry entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getHabitId());
        if (entity.getDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDate());
        }
        statement.bindLong(4, entity.getAmount());
      }
    };
  }

  @Override
  public Object insert(final ProgressEntry entry, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfProgressEntry.insertAndReturnId(entry);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getForDay(final long habitId, final String date,
      final Continuation<? super List<ProgressEntry>> $completion) {
    final String _sql = "SELECT * FROM progress_entries WHERE habitId = ? AND date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, habitId);
    _argIndex = 2;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ProgressEntry>>() {
      @Override
      @NonNull
      public List<ProgressEntry> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfHabitId = CursorUtil.getColumnIndexOrThrow(_cursor, "habitId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final List<ProgressEntry> _result = new ArrayList<ProgressEntry>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ProgressEntry _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpHabitId;
            _tmpHabitId = _cursor.getLong(_cursorIndexOfHabitId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpAmount;
            _tmpAmount = _cursor.getInt(_cursorIndexOfAmount);
            _item = new ProgressEntry(_tmpId,_tmpHabitId,_tmpDate,_tmpAmount);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ProgressEntry>> streamForDay(final String date) {
    final String _sql = "SELECT * FROM progress_entries WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"progress_entries"}, new Callable<List<ProgressEntry>>() {
      @Override
      @NonNull
      public List<ProgressEntry> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfHabitId = CursorUtil.getColumnIndexOrThrow(_cursor, "habitId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final List<ProgressEntry> _result = new ArrayList<ProgressEntry>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ProgressEntry _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpHabitId;
            _tmpHabitId = _cursor.getLong(_cursorIndexOfHabitId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpAmount;
            _tmpAmount = _cursor.getInt(_cursorIndexOfAmount);
            _item = new ProgressEntry(_tmpId,_tmpHabitId,_tmpDate,_tmpAmount);
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
