<template>
<!-- 
  READER: Visual implementation pass working.  Temp data in just to show.  Doing Javascript and hooks next
    --NOTE:  Changed from BUTTONS to SELECT LIST per Mary HIGHLY,HIGHLY recommending this instead of buttons
  BOOK:  Visual implementation pass working.  Temp data in just to show. Doing Javascript and hooks next
  FORMAT:  Visual implementation and options done and ready for KAI phase.  The options are a FIXED list.  Need to do JS and hooks next.
  MINUTES READ:  Visual implementation pass working.  Doing JS and hooks next
  FINISHED BOOK?:  Visual implementation of it working.  Checkbox is check and uncheckable.  Need to do JS and hooks next
  NOTES:  Visual implementation pass working.  Was made so when the box is filled a scrollbar appears.  Need to do JS and hooks next
  SUBMIT BUTTON:  Submit button visual implementation pass working.  Need to do the JS and hooks next.
 -->  

<div>
    <form>
        <label for="Reader">Reader:</label>      
          <select name="readers" id="readers" v-model="usersBooks.userId" required autofocus >     <!-- Reg Discussion Note:  Need for required and autofocus properties?  Confirm -->
          <!-- Test options for SELECT LIST.  DELETE after JS+ Hooks implementation is complete
            <option value="Child 1">Child 1</option>        
            <option value="Child 2">Child 2</option>        
            <option value="Child 3">Child 3</option>        
           -->
           </select><br>
          
        
        <label for="Assigned Books">Book:</label>
          <select name="book" id="assignedBooks" v-model="userBooks.bookId" autofocus />

           <!-- Test options for SELECT LIST.  DELETE after JS+ Hooks implementation is complete
            <option value="Book 1">Book 1</option>        
            <option value="Book 2">Book 2</option>        
            <option value="Book 3">Book 3</option>        
            -->
            <br>
          

        <label for="Book Format">Format:</label>
          <select name="BookFormat" id="BookFormat" v-model="userBooks.BookFormat" autofocus />
            <option value="Paper">Paper</option>
            <option value="Digital">Digital</option>
            <option value="Audiobook">Audiobook</option>
            <option value="ReadAloudReader">Read-Aloud (Reader)</option>
            <option value="ReadAloudListener">Read-Aloud (Listener)</option>
            <option value="Other">Other</option>
          <br>

        <label for="Minutes Read">Minutes Read:</label><br>
          <input type="text" id="MinutesRead" name="MinutesRead" v-model="userBooks.minutesRead"><br>     
            
        <label for="Finished Book">Finished Book?</label>
          <input type="Checkbox" id="FinishedBookCheckbox" v-model="FinishedBookChecked" /><br>

        <label for="ChildReadingNotes">Notes:</label><br>
          <textarea id="ChildReadingNotes" name="ChildReadingNotes" rows="4" cols="50" v-model="userBooks.notes" /><br>
          <button type="submit" class="btn btn-success" >Submit</button>           
    </form>
</div>

</template>

<script>
// Reg Note: I dont think I need the following import until the METHOD is established.
// import BookService from '@/services/BookService.js'; 


export default {
    name: 'users_books',
    data() {
      return {
        usersBooks: {
          userId: "",
          bookId: "",
          minutesRead: "",
          readingFormat:"",
          timesRead:"",
          pastBook:"",
          currentBook:"",
          futureBook:"",
          notes:"",
        }       
      }; 
    }      
}
</script>



<style>

</style>