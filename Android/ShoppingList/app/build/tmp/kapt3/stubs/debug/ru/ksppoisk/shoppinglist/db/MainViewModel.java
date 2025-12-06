package ru.ksppoisk.shoppinglist.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lru/ksppoisk/shoppinglist/db/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "database", "Lru/ksppoisk/shoppinglist/db/MainDataBase;", "(Lru/ksppoisk/shoppinglist/db/MainDataBase;)V", "allNotes", "Landroidx/lifecycle/LiveData;", "", "Lru/ksppoisk/shoppinglist/entities/NoteItem;", "getAllNotes", "()Landroidx/lifecycle/LiveData;", "dao", "Lru/ksppoisk/shoppinglist/db/Dao;", "getDao", "()Lru/ksppoisk/shoppinglist/db/Dao;", "insertNote", "Lkotlinx/coroutines/Job;", "note", "MainViewModelFactory", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final ru.ksppoisk.shoppinglist.db.Dao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<ru.ksppoisk.shoppinglist.entities.NoteItem>> allNotes = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.db.MainDataBase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.ksppoisk.shoppinglist.db.Dao getDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<ru.ksppoisk.shoppinglist.entities.NoteItem>> getAllNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertNote(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.NoteItem note) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lru/ksppoisk/shoppinglist/db/MainViewModel$MainViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "database", "Lru/ksppoisk/shoppinglist/db/MainDataBase;", "(Lru/ksppoisk/shoppinglist/db/MainDataBase;)V", "getDatabase", "()Lru/ksppoisk/shoppinglist/db/MainDataBase;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class MainViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final ru.ksppoisk.shoppinglist.db.MainDataBase database = null;
        
        public MainViewModelFactory(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.db.MainDataBase database) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ru.ksppoisk.shoppinglist.db.MainDataBase getDatabase() {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}