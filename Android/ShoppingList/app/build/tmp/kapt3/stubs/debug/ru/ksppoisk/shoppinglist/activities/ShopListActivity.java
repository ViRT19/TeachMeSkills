package ru.ksppoisk.shoppinglist.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010\'\u001a\u00020\u0019H\u0002J\u0018\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020#H\u0016J\u0012\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u0019H\u0014J\u0010\u00103\u001a\u00020/2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u00104\u001a\u00020\u0019H\u0014J\b\u00105\u001a\u00020\u0019H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lru/ksppoisk/shoppinglist/activities/ShopListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$Listener;", "()V", "adapter", "Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter;", "binding", "Lru/ksppoisk/shoppinglist/databinding/ActivityShopListBinding;", "defPref", "Landroid/content/SharedPreferences;", "edItem", "Landroid/widget/EditText;", "mainViewModel", "Lru/ksppoisk/shoppinglist/db/MainViewModel;", "getMainViewModel", "()Lru/ksppoisk/shoppinglist/db/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "saveItem", "Landroid/view/MenuItem;", "shopListNameItem", "Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;", "textWatcher", "Landroid/text/TextWatcher;", "addNewShopItem", "", "name", "", "editLibraryItem", "item", "Lru/ksppoisk/shoppinglist/entities/ShopListItem;", "editListItem", "expandActionView", "Landroid/view/MenuItem$OnActionExpandListener;", "getSelectedTheme", "", "init", "initRcView", "libraryItemObserver", "listItemObserver", "onClickItem", "shopListItem", "state", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "onPause", "saveItemCount", "Companion", "app_debug"})
public final class ShopListActivity extends androidx.appcompat.app.AppCompatActivity implements ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.Listener {
    private ru.ksppoisk.shoppinglist.databinding.ActivityShopListBinding binding;
    private android.content.SharedPreferences defPref;
    @org.jetbrains.annotations.Nullable()
    private ru.ksppoisk.shoppinglist.entities.ShopListNameItem shopListNameItem;
    private android.view.MenuItem saveItem;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText edItem;
    @org.jetbrains.annotations.Nullable()
    private ru.ksppoisk.shoppinglist.db.ShopListItemAdapter adapter;
    private android.text.TextWatcher textWatcher;
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
    
    private final android.text.TextWatcher textWatcher() {
        return null;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void addNewShopItem(java.lang.String name) {
    }
    
    private final void listItemObserver() {
    }
    
    private final void libraryItemObserver() {
    }
    
    private final void initRcView() {
    }
    
    private final android.view.MenuItem.OnActionExpandListener expandActionView() {
        return null;
    }
    
    private final void init() {
    }
    
    @java.lang.Override()
    public void onClickItem(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.ShopListItem shopListItem, int state) {
    }
    
    private final void editListItem(ru.ksppoisk.shoppinglist.entities.ShopListItem item) {
    }
    
    private final void editLibraryItem(ru.ksppoisk.shoppinglist.entities.ShopListItem item) {
    }
    
    private final void saveItemCount() {
    }
    
    private final int getSelectedTheme() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lru/ksppoisk/shoppinglist/activities/ShopListActivity$Companion;", "", "()V", "SHOP_LIST_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}