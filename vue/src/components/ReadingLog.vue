<template>
  <div class="reading-log">
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
    <form class="form-reading-log">
      <h1 class="form-header">Reading Log</h1>
      <div class="form-body">
        <!-- Reader and Book -->
      <div class="horizontal-group">
        <div class="form-group-wide left">
          <div class='split-form-one-group-left'>
          <label class="label-title" for="readers">Reader</label>
          <select
            class="drop-down"
            name="readers"
            id="readers"
            v-model="userBook.userId"
            required
            autofocus
          >
            <option disabled value="">Pick a Reader</option>
            <option v-for="name in reader" v-bind:key="name.index">
              {{ name }}
            </option></select
          ><br />
          </div>
           <div class='split-form-two-group-left'>
            <label for="MinutesRead" class="label-title">Minutes Read</label>
              <input
                type="text"
                id="minutesread"
                name="MinutesRead"
                v-model="userBook.minutesRead"
              />
          </div>
          


          
        </div>
        <div class="form-group-narrow right">
            <label for="FinishedBookCheckbox" class="label-title">Finished Book?</label>
            <input
              type="Checkbox"
              id="finishedbookcheckbox"
              v-model="userBook.currentBook"
            /><br />
        </div>
      </div>


      <!-- Format, Minutes Read, Notes-->
      <div class="horizontal-group">
        <div class="form-group-wide left">
          <div class='split-form-one-group-left'>
            <label for="BookFormat" class="label-title">Format</label>
            <select
              class="drop-down"
              name="BookFormat"
              id="bookformat"
              v-model="userBook.readingFormat"
              autofocus
            >
              <option disabled value="">Pick Book Format</option>
              <option value="Paper">Paper</option>
              <option value="Digital">Digital</option>
              <option value="Audiobook">Audiobook</option>
              <option value="ReadAloudReader">Read-Aloud (Reader)</option>
              <option value="ReadAloudListener">Read-Aloud (Listener)</option>
              <option value="Other">Other</option>
            </select>
          </div>

          <div class='split-form-two-group-left'>
            <label for="assignedBooks" class="label-title">Book</label>
            <select
              class="drop-down"
              name="book"
              id="assignedbooks"
              v-model="userBook.bookId"
              autofocus
            >
              <option disabled value="">Pick a Book</option>
              <option v-for="bookId in userBook" v-bind:key="bookId">
                {{ bookId }}
              </option></select
            >
          </div>

         



        </div>
        <div class="form-group-narrow right">
          <label for="ChildReadingNotes" class="label-title">Notes</label><br />
          <textarea
            id="childreadingnotes"
            name="ChildReadingNotes"
            rows="4"
            cols="45"
            v-model="userBook.notes" 
          /><br />
        </div>
      </div>
    </div>
      <div class="form-footer">
        <button class="btn" type="submit" v-on:click="LogReading">
        Submit Note
        </button>
      </div>
    </form>
</div>
</div>
</template>

<script>
import BookService from "@/services/BookService.js";

export default {
  name: "userBook",
  data() {
    return {
      userBook: {
        userId: "",
        bookId: "",
        minutesRead: "",
        readingFormat: "",
        timesRead: "",
        pastBook: "",
        currentBook: "",
        futureBook: "",
        notes: ""
      },
      reader: ["Colin", "Nolan", "Reg", "Kai"],
    };
  },
  methods: {
    LogReading() {
      console.log("Checking for userID" + this.userId);
      BookService.LogReading(this.userBook);
    },
  },
};

// created() {
//   BookService.getUserBooksUserId(this.userId).then((response) => {
//     this.userId = response.data;
//      })
//   },
//  }

</script>


<style>
#readers{
  width:125px;
  margin-bottom: 15px;
  margin-top: 2px;
}
#minutesread{
  margin-top:2px;
  margin-bottom: 25px;
  width: 80px;
}
#assignedbooks{
 margin-top:30px;
 width: 150px;
}
#bookformat{
 margin-top:30px;
 width: 140px;
}
</style>