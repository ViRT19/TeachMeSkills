package ru.ksppoisk.shoppinglist.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\f0\u0012H\'J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u00122\u0006\u0010\t\u001a\u00020\u0005H\'J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\f0\u0012H\'J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010&\u001a\u00020\u00032\u0006\u0010\'\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\"J\u0016\u0010(\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010 \u00a8\u0006)"}, d2 = {"Lru/ksppoisk/shoppinglist/db/Dao;", "", "deleteLibraryItem", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNote", "deleteShopItemsByListId", "listId", "deleteShopListName", "getAllLibraryItems", "", "Lru/ksppoisk/shoppinglist/entities/LibraryItem;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotes", "Lkotlinx/coroutines/flow/Flow;", "Lru/ksppoisk/shoppinglist/entities/NoteItem;", "getAllShopListItems", "Lru/ksppoisk/shoppinglist/entities/ShopListItem;", "getAllShopListNames", "Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;", "insertItem", "shopListItem", "(Lru/ksppoisk/shoppinglist/entities/ShopListItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLibraryItem", "libraryItem", "(Lru/ksppoisk/shoppinglist/entities/LibraryItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNote", "note", "(Lru/ksppoisk/shoppinglist/entities/NoteItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertShopListName", "(Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLibraryItem", "item", "updateListItem", "updateListName", "shopListName", "updateNote", "app_debug"})
@androidx.room.Dao()
public abstract interface Dao {
    
    @androidx.room.Query(value = "SELECT * FROM note_list")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<ru.ksppoisk.shoppinglist.entities.NoteItem>> getAllNotes();
    
    @androidx.room.Query(value = "SELECT * FROM shopping_list_names")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<ru.ksppoisk.shoppinglist.entities.ShopListNameItem>> getAllShopListNames();
    
    @androidx.room.Query(value = "SELECT * FROM shop_list_item WHERE listId LIKE :listId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<ru.ksppoisk.shoppinglist.entities.ShopListItem>> getAllShopListItems(int listId);
    
    @androidx.room.Query(value = "SELECT * FROM library WHERE name LIKE :name")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllLibraryItems(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.ksppoisk.shoppinglist.entities.LibraryItem>> $completion);
    
    @androidx.room.Query(value = "DELETE FROM note_list WHERE id IS :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNote(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM shopping_list_names WHERE id IS :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteShopListName(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM shop_list_item WHERE listId LIKE :listId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteShopItemsByListId(int listId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM library WHERE id IS :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteLibraryItem(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNote(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.NoteItem note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertItem(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.ShopListItem shopListItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLibraryItem(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.LibraryItem libraryItem, @org.jetbrains.annotations.NotNull()
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
    public abstract java.lang.Object updateLibraryItem(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.LibraryItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateListItem(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.ShopListItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateListName(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.ShopListNameItem shopListName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}