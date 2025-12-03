package ru.ksppoisk.shoppinglist.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lru/ksppoisk/shoppinglist/db/NoteAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/ksppoisk/shoppinglist/entities/NoteItem;", "Lru/ksppoisk/shoppinglist/db/NoteAdapter$ItemHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemComporator", "ItemHolder", "app_debug"})
public final class NoteAdapter extends androidx.recyclerview.widget.ListAdapter<ru.ksppoisk.shoppinglist.entities.NoteItem, ru.ksppoisk.shoppinglist.db.NoteAdapter.ItemHolder> {
    
    public NoteAdapter() {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public ru.ksppoisk.shoppinglist.db.NoteAdapter.ItemHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.db.NoteAdapter.ItemHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lru/ksppoisk/shoppinglist/db/NoteAdapter$ItemComporator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/ksppoisk/shoppinglist/entities/NoteItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class ItemComporator extends androidx.recyclerview.widget.DiffUtil.ItemCallback<ru.ksppoisk.shoppinglist.entities.NoteItem> {
        
        public ItemComporator() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.NoteItem oldItem, @org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.NoteItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.NoteItem oldItem, @org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.NoteItem newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lru/ksppoisk/shoppinglist/db/NoteAdapter$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lru/ksppoisk/shoppinglist/databinding/NoteListItemBinding;", "setData", "", "note", "Lru/ksppoisk/shoppinglist/entities/NoteItem;", "Companion", "app_debug"})
    public static final class ItemHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final ru.ksppoisk.shoppinglist.databinding.NoteListItemBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        public static final ru.ksppoisk.shoppinglist.db.NoteAdapter.ItemHolder.Companion Companion = null;
        
        public ItemHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        ru.ksppoisk.shoppinglist.entities.NoteItem note) {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lru/ksppoisk/shoppinglist/db/NoteAdapter$ItemHolder$Companion;", "", "()V", "create", "Lru/ksppoisk/shoppinglist/db/NoteAdapter$ItemHolder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ru.ksppoisk.shoppinglist.db.NoteAdapter.ItemHolder create(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
        }
    }
}