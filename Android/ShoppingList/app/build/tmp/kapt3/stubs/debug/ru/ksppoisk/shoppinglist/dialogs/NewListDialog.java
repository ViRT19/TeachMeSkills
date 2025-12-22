package ru.ksppoisk.shoppinglist.dialogs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\n"}, d2 = {"Lru/ksppoisk/shoppinglist/dialogs/NewListDialog;", "", "()V", "showDialog", "", "context", "Landroid/content/Context;", "listener", "Lru/ksppoisk/shoppinglist/dialogs/NewListDialog$Listener;", "Listener", "app_debug"})
public final class NewListDialog {
    @org.jetbrains.annotations.NotNull()
    public static final ru.ksppoisk.shoppinglist.dialogs.NewListDialog INSTANCE = null;
    
    private NewListDialog() {
        super();
    }
    
    public final void showDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.dialogs.NewListDialog.Listener listener) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lru/ksppoisk/shoppinglist/dialogs/NewListDialog$Listener;", "", "onClick", "", "name", "", "app_debug"})
    public static abstract interface Listener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        java.lang.String name);
    }
}