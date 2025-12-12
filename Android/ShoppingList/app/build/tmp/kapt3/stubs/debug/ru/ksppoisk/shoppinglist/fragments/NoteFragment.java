package ru.ksppoisk.shoppinglist.fragments;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \'2\u00020\u00012\u00020\u0002:\u0001\'B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\u0012H\u0002J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006("}, d2 = {"Lru/ksppoisk/shoppinglist/fragments/NoteFragment;", "Lru/ksppoisk/shoppinglist/fragments/BaseFragment;", "Lru/ksppoisk/shoppinglist/db/NoteAdapter$Listener;", "()V", "adapter", "Lru/ksppoisk/shoppinglist/db/NoteAdapter;", "binding", "Lru/ksppoisk/shoppinglist/databinding/FragmentNoteBinding;", "editLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "mainViewModel", "Lru/ksppoisk/shoppinglist/db/MainViewModel;", "getMainViewModel", "()Lru/ksppoisk/shoppinglist/db/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "deleteItem", "", "id", "", "initRcView", "observer", "onClickItem", "note", "Lru/ksppoisk/shoppinglist/entities/NoteItem;", "onClickNew", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onEditResult", "onViewCreated", "view", "Companion", "app_debug"})
public final class NoteFragment extends ru.ksppoisk.shoppinglist.fragments.BaseFragment implements ru.ksppoisk.shoppinglist.db.NoteAdapter.Listener {
    private ru.ksppoisk.shoppinglist.databinding.FragmentNoteBinding binding;
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> editLauncher;
    private ru.ksppoisk.shoppinglist.db.NoteAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NEW_NOTE_KEY = "new_note_key";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EDIT_STAY_KEY = "edit_stay_key";
    @org.jetbrains.annotations.NotNull()
    public static final ru.ksppoisk.shoppinglist.fragments.NoteFragment.Companion Companion = null;
    
    public NoteFragment() {
        super();
    }
    
    private final ru.ksppoisk.shoppinglist.db.MainViewModel getMainViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onClickNew() {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initRcView() {
    }
    
    private final void observer() {
    }
    
    private final void onEditResult() {
    }
    
    @java.lang.Override()
    public void deleteItem(int id) {
    }
    
    @java.lang.Override()
    public void onClickItem(@org.jetbrains.annotations.NotNull()
    ru.ksppoisk.shoppinglist.entities.NoteItem note) {
    }
    
    @kotlin.jvm.JvmStatic()
    @org.jetbrains.annotations.NotNull()
    public static final ru.ksppoisk.shoppinglist.fragments.NoteFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lru/ksppoisk/shoppinglist/fragments/NoteFragment$Companion;", "", "()V", "EDIT_STAY_KEY", "", "NEW_NOTE_KEY", "newInstance", "Lru/ksppoisk/shoppinglist/fragments/NoteFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.jvm.JvmStatic()
        @org.jetbrains.annotations.NotNull()
        public final ru.ksppoisk.shoppinglist.fragments.NoteFragment newInstance() {
            return null;
        }
    }
}