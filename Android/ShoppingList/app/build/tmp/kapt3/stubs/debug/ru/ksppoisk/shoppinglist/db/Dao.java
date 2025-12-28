package ru.ksppoisk.shoppinglist.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\tH\'J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lru/ksppoisk/shoppinglist/db/Dao;", "", "deleteNote", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteShopListName", "getAllNotes", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/ksppoisk/shoppinglist/entities/NoteItem;", "getAllShopListNames", "Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;", "insertNote", "note", "(Lru/ksppoisk/shoppinglist/entities/NoteItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertShopListName", "name", "(Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateListName", "shopListName", "updateNote", "app_debug"})
@androidx.room.Dao()
public abstract interface Dao {
    
    @androidx.room.Query(value = "SELECT * FROM note_list")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<ru.ksppoisk.shoppinglist.entities.NoteItem>> getAllNotes();
    
    @androidx.room.Query(value = "SELECT * FROM shopping_list_names")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<ru.ksppoisk.shoppinglist.entities.ShopListNameItem>> getAllShopListNames();
    
    @androidx.room.Query(value = "DELETE FROM note_list WHERE id IS :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNote(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM shopping_list_names WHERE id IS :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteShopListName(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNote(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.NoteItem note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertShopListName(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.ShopListNameItem name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateNote(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.NoteItem note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateListName(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.ShopListNameItem shopListName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}