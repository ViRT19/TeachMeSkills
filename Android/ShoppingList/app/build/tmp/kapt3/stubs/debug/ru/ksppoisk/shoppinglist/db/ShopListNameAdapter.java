package ru.ksppoisk.shoppinglist.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0010\u0011\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;", "Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter$ItemHolder;", "listener", "Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter$Listener;", "(Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter$Listener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemComporator", "ItemHolder", "Listener", "app_debug"})
public final class ShopListNameAdapter extends androidx.recyclerview.widget.ListAdapter<ru.ksppoisk.shoppinglist.entities.ShopListNameItem, ru.ksppoisk.shoppinglist.db.ShopListNameAdapter.ItemHolder> {
    @org.jetbrains.annotations.NotNull()
    private final ru.ksppoisk.shoppinglist.db.ShopListNameAdapter.Listener listener = null;
    
    public ShopListNameAdapter(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.db.ShopListNameAdapter.Listener listener) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public ru.ksppoisk.shoppinglist.db.ShopListNameAdapter.ItemHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.db.ShopListNameAdapter.ItemHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter$ItemComporator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class ItemComporator extends androidx.recyclerview.widget.DiffUtil.ItemCallback<ru.ksppoisk.shoppinglist.entities.ShopListNameItem> {
        
        public ItemComporator() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListNameItem oldItem, @org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListNameItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListNameItem oldItem, @org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListNameItem newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lru/ksppoisk/shoppinglist/databinding/ListNameItemBinding;", "setData", "", "shopListNameItem", "Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;", "listener", "Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter$Listener;", "Companion", "app_debug"})
    public static final class ItemHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final ru.ksppoisk.shoppinglist.databinding.ListNameItemBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        public static final ru.ksppoisk.shoppinglist.db.ShopListNameAdapter.ItemHolder.Companion Companion = null;
        
        public ItemHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListNameItem shopListNameItem, @org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.db.ShopListNameAdapter.Listener listener) {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter$ItemHolder$Companion;", "", "()V", "create", "Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter$ItemHolder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ru.ksppoisk.shoppinglist.db.ShopListNameAdapter.ItemHolder create(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListNameAdapter$Listener;", "", "deleteItem", "", "id", "", "editItem", "shopListName", "Lru/ksppoisk/shoppinglist/entities/ShopListNameItem;", "onClickItem", "app_debug"})
    public static abstract interface Listener {
        
        public abstract void deleteItem(int id);
        
        public abstract void editItem(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListNameItem shopListName);
        
        public abstract void onClickItem(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListNameItem shopListName);
    }
}