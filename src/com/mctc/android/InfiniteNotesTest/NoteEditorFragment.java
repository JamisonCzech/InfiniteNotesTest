package com.mctc.android.InfiniteNotesTest;

import JavaClasses.NoteItemData;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;

public class NoteEditorFragment extends Fragment
{
   // Initialize member variables
   EditText editText;
   private NoteItemData note;
   View view = null;

   //No args constructor
   public NoteEditorFragment()
   {

   }

   public void onCreate(Bundle savedInstanceState)
   {
      // TODO Auto-generated method stub
      super.onCreate(savedInstanceState);
      setHasOptionsMenu(true);
   }



   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.activity_note_editor, container, false);



      Intent intent = getActivity().getIntent();
      note = new NoteItemData();
      note.setKey(intent.getStringExtra("key")); // string extra method
      note.setText(intent.getStringExtra("text"));// string extra method

      // edit text to enter data
      EditText editText =
       (EditText) view.findViewById(R.id.noteEditText);

       editText.setText(note.getText());
       editText.setSelection(note.getText().length());

      return view;
   }

   @Override
   public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
   {
      // TODO Auto-generated method stub
      super.onCreateOptionsMenu(menu, inflater);
      inflater.inflate(R.menu.main, menu);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
      // handle item selection
      switch (item.getItemId())
      {
         case R.id.action_settings:

            return true;
         default:
            return super.onOptionsItemSelected(item);
      }
   }


   public void saveAndFinish()
   {
      // edit text to enter data
      EditText editText =
      (EditText) view.findViewById(R.id.noteEditText);
      String noteText = editText.getText().toString();

      Intent intent = new Intent();
      intent.putExtra("key", note.getKey());
      intent.putExtra("text", noteText);
      getActivity().setResult(getActivity().RESULT_OK ,intent);
      getActivity().finish();
   }
}//END method saveAndFinish
