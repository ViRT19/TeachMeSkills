package ru.ksppoisk.shoppinglist.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0012\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lru/ksppoisk/shoppinglist/activities/ShopListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$Listener;", "()V", "adapter", "Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter;", "binding", "Lru/ksppoisk/shoppinglist/databinding/ActivityShopListBinding;", "edItem", "Landroid/widget/EditText;", "mainViewModel", "Lru/ksppoisk/shoppinglist/db/MainViewModel;", "getMainViewModel", "()Lru/ksppoisk/shoppinglist/db/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "saveItem", "Landroid/view/MenuItem;", "shopListNameItem", "Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;", "addNewShopItem", "", "deleteItem", "id", "", "editItem", "shopListName", "expandActionView", "Landroid/view/MenuItem$OnActionExpandListener;", "init", "initRcView", "listItemObserver", "onClickItem", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Companion", "app_debug"})
public final class ShopListActivity extends androidx.appcompat.app.AppCompatActivity implements ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.Listener {
    private ru.ksppoisk.shoppinglist.databinding.ActivityShopListBinding binding;
    @org.jetbrains.annotations.Nullable()
    private ru.ksppoisk.shoppinglist.entities.ShopListNameItem shopListNameItem;
    private android.view.MenuItem saveItem;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText edItem;
    @org.jetbrains.annotations.Nullable()
    private ru.ksppoisk.shoppinglist.db.ShopListItemAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SHOP_LIST_NAME = "shop_list_name";
    @org.jetbrains.annotations.NotNull()
    public static final ru.ksppoisk.shoppinglist.activities.ShopListActivity.Companion Companion = null;
    
    public ShopListActivity() {
        super();
    }
    
    private final ru.ksppoisk.shoppinglist.db.MainViewModel getMainViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void addNewShopItem() {
    }
    
    private final void listItemObserver() {
    }
    
    private final void initRcView() {
    }
    
    private final android.view.MenuItem.OnActionExpandListener expandActionView() {
        return null;
    }
    
    private final void init() {
    }
    
    @java.lang.Override()
    public void deleteItem(int id) {
    }
    
    @java.lang.Override()
    public void editItem(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.ShopListNameItem shopListName) {
    }
    
    @java.lang.Override()
    public void onClickItem(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.ShopListNameItem shopListName) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lru/ksppoisk/shoppinglist/activities/ShopListActivity$Companion;", "", "()V", "SHOP_LIST_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}