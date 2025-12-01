package ru.ksppoisk.shoppinglist.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lru/ksppoisk/shoppinglist/db/MainDataBase;", "Landroidx/room/RoomDatabase;", "()V", "getDao", "Lru/ksppoisk/shoppinglist/db/Dao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {ru.ksppoisk.shoppinglist.entities.LibraryItem.class, ru.ksppoisk.shoppinglist.entities.NoteItem.class, ru.ksppoisk.shoppinglist.entities.ShoppingListItem.class, ru.ksppoisk.shoppinglist.entities.ShoppingListNames.class}, version = 1)
public abstract class MainDataBase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile ru.ksppoisk.shoppinglist.db.MainDataBase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final ru.ksppoisk.shoppinglist.db.MainDataBase.Companion Companion = null;
    
    public MainDataBase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract ru.ksppoisk.shoppinglist.db.Dao getDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lru/ksppoisk/shoppinglist/db/MainDataBase$Companion;", "", "()V", "INSTANCE", "Lru/ksppoisk/shoppinglist/db/MainDataBase;", "getDataBase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ru.ksppoisk.shoppinglist.db.MainDataBase getDataBase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}