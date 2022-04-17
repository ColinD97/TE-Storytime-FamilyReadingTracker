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
          <select name="readers" id="readers" v-model="userBook.userId" required autofocus>
            <option disabled value="">Pick a Reader</option>
            <option v-for="userId in userBook" v-bind:key="userId">{{userId}}</option>               
           </select><br>            
        
        <label for="Assigned Books">Book:</label>
          <select name="book" id="assignedBooks" v-model="userBook.bookId" autofocus >
            <option disabled value="">Pick a Book</option>
            <option v-for="bookId in userBook" v-bind:key="bookId">{{bookId}}</option>
            </select><br>          

        <label for="Book Format">Format:</label>
          <select name="BookFormat" id="BookFormat" v-model="userBook.readingFormat" autofocus />  
            <!-- <option disabled value="">Pick Book Format</option>  -->
            <option value="Paper">Paper</option>
            <option value="Digital">Digital</option>
            <option value="Audiobook">Audiobook</option>
            <option value="ReadAloudReader">Read-Aloud (Reader)</option>
            <option value="ReadAloudListener">Read-Aloud (Listener)</option>
            <option value="Other">Other</option>
          <br>

        <label for="Minutes Read">Minutes Read:</label><br>
          <input type="text" id="MinutesRead" name="MinutesRead" v-model="userBook.minutesRead"><br>     
            
        <label for="Finished Book">Finished Book?</label>
          <input type="Checkbox" id="FinishedBookCheckbox" v-model="FinishedBookChecked" /><br>

        <label for="ChildReadingNotes">Notes:</label><br>
          <textarea id="ChildReadingNotes" name="ChildReadingNotes" rows="4" cols="50" v-model="userBook.notes" /><br>
          <button class="btn" type="submit" v-on:click="notes">Submit Note</button>                                 
    </form>
</div>

</template>

<script>
// import BookService from '@/services/BookService.js'; 

export default {
    name: 'userBook',
    data() {
      return {                 
        userBook: {
          userId: ['A','B','C'],
          bookId: 'A Sword of Swords',
          minutesRead: '',
          readingFormat: '',
          timesRead: '',
          pastBook: '',
          currentBook: '',
          futureBook: '',
          notes: '',
        }       
      } 
    }
};
    

  //   created() {
  //     BookService.getUserBooksUserId().then((response) => {
  //       this.userId = response.data;
  //     }
  //  };
   

    

//   methods: {
//     LogReading() {          
//       console.log('Log Reading Testing' + this.userBook)        
   
//     }     

//   }      
// }
</script>



<style>
</style>