package com.artimesblue.focusflow.data;

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
public final class AppDatabase_Impl extends AppDatabase {
  private volatile HabitDao _habitDao;

  private volatile ProgressDao _progressDao;

  private volatile GoalDao _goalDao;

  private volatile TaskEntryDao _taskEntryDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `habits` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `dailyGoal` INTEGER NOT NULL, `unit` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `progress_entries` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `habitId` INTEGER NOT NULL, `date` TEXT NOT NULL, `amount` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `goals` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `category` TEXT NOT NULL, `difficulty` INTEGER NOT NULL, `targetMinutes` INTEGER NOT NULL, `createdAt` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `task_entries` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `goalId` INTEGER NOT NULL, `date` TEXT NOT NULL, `durationMinutes` INTEGER NOT NULL, `completed` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f818c1283ef2cc690f60ba34ea17baea')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `habits`");
        db.execSQL("DROP TABLE IF EXISTS `progress_entries`");
        db.execSQL("DROP TABLE IF EXISTS `goals`");
        db.execSQL("DROP TABLE IF EXISTS `task_entries`");
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
        final HashMap<String, TableInfo.Column> _columnsHabits = new HashMap<String, TableInfo.Column>(4);
        _columnsHabits.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHabits.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHabits.put("dailyGoal", new TableInfo.Column("dailyGoal", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHabits.put("unit", new TableInfo.Column("unit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHabits = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHabits = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHabits = new TableInfo("habits", _columnsHabits, _foreignKeysHabits, _indicesHabits);
        final TableInfo _existingHabits = TableInfo.read(db, "habits");
        if (!_infoHabits.equals(_existingHabits)) {
          return new RoomOpenHelper.ValidationResult(false, "habits(com.artimesblue.focusflow.data.Habit).\n"
                  + " Expected:\n" + _infoHabits + "\n"
                  + " Found:\n" + _existingHabits);
        }
        final HashMap<String, TableInfo.Column> _columnsProgressEntries = new HashMap<String, TableInfo.Column>(4);
        _columnsProgressEntries.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProgressEntries.put("habitId", new TableInfo.Column("habitId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProgressEntries.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProgressEntries.put("amount", new TableInfo.Column("amount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProgressEntries = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProgressEntries = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProgressEntries = new TableInfo("progress_entries", _columnsProgressEntries, _foreignKeysProgressEntries, _indicesProgressEntries);
        final TableInfo _existingProgressEntries = TableInfo.read(db, "progress_entries");
        if (!_infoProgressEntries.equals(_existingProgressEntries)) {
          return new RoomOpenHelper.ValidationResult(false, "progress_entries(com.artimesblue.focusflow.data.ProgressEntry).\n"
                  + " Expected:\n" + _infoProgressEntries + "\n"
                  + " Found:\n" + _existingProgressEntries);
        }
        final HashMap<String, TableInfo.Column> _columnsGoals = new HashMap<String, TableInfo.Column>(6);
        _columnsGoals.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("difficulty", new TableInfo.Column("difficulty", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("targetMinutes", new TableInfo.Column("targetMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGoals.put("createdAt", new TableInfo.Column("createdAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGoals = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGoals = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGoals = new TableInfo("goals", _columnsGoals, _foreignKeysGoals, _indicesGoals);
        final TableInfo _existingGoals = TableInfo.read(db, "goals");
        if (!_infoGoals.equals(_existingGoals)) {
          return new RoomOpenHelper.ValidationResult(false, "goals(com.artimesblue.focusflow.data.Goal).\n"
                  + " Expected:\n" + _infoGoals + "\n"
                  + " Found:\n" + _existingGoals);
        }
        final HashMap<String, TableInfo.Column> _columnsTaskEntries = new HashMap<String, TableInfo.Column>(5);
        _columnsTaskEntries.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskEntries.put("goalId", new TableInfo.Column("goalId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskEntries.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskEntries.put("durationMinutes", new TableInfo.Column("durationMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTaskEntries.put("completed", new TableInfo.Column("completed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTaskEntries = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTaskEntries = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTaskEntries = new TableInfo("task_entries", _columnsTaskEntries, _foreignKeysTaskEntries, _indicesTaskEntries);
        final TableInfo _existingTaskEntries = TableInfo.read(db, "task_entries");
        if (!_infoTaskEntries.equals(_existingTaskEntries)) {
          return new RoomOpenHelper.ValidationResult(false, "task_entries(com.artimesblue.focusflow.data.TaskEntry).\n"
                  + " Expected:\n" + _infoTaskEntries + "\n"
                  + " Found:\n" + _existingTaskEntries);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f818c1283ef2cc690f60ba34ea17baea", "a1e235c8e6e5f72b42e7ab0217d6a5fd");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "habits","progress_entries","goals","task_entries");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `habits`");
      _db.execSQL("DELETE FROM `progress_entries`");
      _db.execSQL("DELETE FROM `goals`");
      _db.execSQL("DELETE FROM `task_entries`");
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
    _typeConvertersMap.put(HabitDao.class, HabitDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProgressDao.class, ProgressDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GoalDao.class, GoalDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TaskEntryDao.class, TaskEntryDao_Impl.getRequiredConverters());
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
  public HabitDao habitDao() {
    if (_habitDao != null) {
      return _habitDao;
    } else {
      synchronized(this) {
        if(_habitDao == null) {
          _habitDao = new HabitDao_Impl(this);
        }
        return _habitDao;
      }
    }
  }

  @Override
  public ProgressDao progressDao() {
    if (_progressDao != null) {
      return _progressDao;
    } else {
      synchronized(this) {
        if(_progressDao == null) {
          _progressDao = new ProgressDao_Impl(this);
        }
        return _progressDao;
      }
    }
  }

  @Override
  public GoalDao goalDao() {
    if (_goalDao != null) {
      return _goalDao;
    } else {
      synchronized(this) {
        if(_goalDao == null) {
          _goalDao = new GoalDao_Impl(this);
        }
        return _goalDao;
      }
    }
  }

  @Override
  public TaskEntryDao taskEntryDao() {
    if (_taskEntryDao != null) {
      return _taskEntryDao;
    } else {
      synchronized(this) {
        if(_taskEntryDao == null) {
          _taskEntryDao = new TaskEntryDao_Impl(this);
        }
        return _taskEntryDao;
      }
    }
  }
}
