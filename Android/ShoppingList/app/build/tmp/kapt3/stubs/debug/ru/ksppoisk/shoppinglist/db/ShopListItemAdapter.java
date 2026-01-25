package ru.ksppoisk.shoppinglist.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0011\u0012\u0013\u0014B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/ksppoisk/shoppinglist/entities/ShopListItem;", "Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$ItemHolder;", "listener", "Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$Listener;", "(Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$Listener;)V", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ItemComporator", "ItemHolder", "Listener", "app_debug"})
public final class ShopListItemAdapter extends androidx.recyclerview.widget.ListAdapter<ru.ksppoisk.shoppinglist.entities.ShopListItem, ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.ItemHolder> {
    @org.jetbrains.annotations.NotNull()
    private final ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.Listener listener = null;
    public static final int EDIT = 0;
    public static final int CHECK_BOX = 1;
    public static final int EDIT_LIBRARY_ITEM = 2;
    public static final int DELETE_LIBRARY_ITEM = 3;
    public static final int ADD = 4;
    @org.jetbrains.annotations.NotNull()
    public static final ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.Companion Companion = null;
    
    public ShopListItemAdapter(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.Listener listener) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.ItemHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.ItemHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$Companion;", "", "()V", "ADD", "", "CHECK_BOX", "DELETE_LIBRARY_ITEM", "EDIT", "EDIT_LIBRARY_ITEM", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$ItemComporator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/ksppoisk/shoppinglist/entities/ShopListItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class ItemComporator extends androidx.recyclerview.widget.DiffUtil.ItemCallback<ru.ksppoisk.shoppinglist.entities.ShopListItem> {
        
        public ItemComporator() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListItem oldItem, @org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListItem oldItem, @org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListItem newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "infoVisibility", "", "shopListItem", "Lru/ksppoisk/shoppinglist/entities/ShopListItem;", "setItemData", "", "listener", "Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$Listener;", "setLibraryData", "setPaintFlagAndColor", "binding", "Lru/ksppoisk/shoppinglist/databinding/ShopListItemBinding;", "Companion", "app_debug"})
    public static final class ItemHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.view.View view = null;
        @org.jetbrains.annotations.NotNull()
        public static final ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.ItemHolder.Companion Companion = null;
        
        public ItemHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getView() {
            return null;
        }
        
        public final void setItemData(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListItem shopListItem, @org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.Listener listener) {
        }
        
        public final void setLibraryData(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListItem shopListItem, @org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.Listener listener) {
        }
        
        private final void setPaintFlagAndColor(ru.ksppoisk.shoppinglist.databinding.ShopListItemBinding binding) {
        }
        
        private final int infoVisibility(ru.ksppoisk.shoppinglist.entities.ShopListItem shopListItem) {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$ItemHolder$Companion;", "", "()V", "createLibraryItem", "Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$ItemHolder;", "parent", "Landroid/view/ViewGroup;", "createShopItem", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.ItemHolder createShopItem(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ru.ksppoisk.shoppinglist.db.ShopListItemAdapter.ItemHolder createLibraryItem(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lru/ksppoisk/shoppinglist/db/ShopListItemAdapter$Listener;", "", "onClickItem", "", "shopListItem", "Lru/ksppoisk/shoppinglist/entities/ShopListItem;", "state", "", "app_debug"})
    public static abstract interface Listener {
        
        public abstract void onClickItem(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.ShopListItem shopListItem, int state);
    }
}