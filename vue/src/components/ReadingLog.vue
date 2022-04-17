<template>
  <div class="reading-log">
    <div class="title">
      <h1>Reading Log <span>What are we reading together today?</span></h1>
    </div>

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
        <label for="readers">Reader:</label>
        <select
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

        <label for="assignedBooks">Book:</label>
        <select
          name="book"
          id="assignedBooks"
          v-model="userBook.bookId"
          autofocus
        >
          <option disabled value="">Pick a Book</option>
          <option v-for="bookId in userBook" v-bind:key="bookId">
            {{ bookId }}
          </option></select
        ><br />

        <label for="BookFormat">Format:</label>
        <select
          name="BookFormat"
          id="BookFormat"
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
        <br />

        <label for="MinutesRead">Minutes Read:</label><br />
        <input
          type="text"
          id="MinutesRead"
          name="MinutesRead"
          v-model="userBook.minutesRead"
        /><br />

        <label for="FinishedBookCheckbox">Finished Book?</label>
        <input
          type="Checkbox"
          id="FinishedBookCheckbox"
          v-model="userBook.currentBook"
        /><br />

        <label for="ChildReadingNotes">Notes:</label><br />
        <textarea
          id="ChildReadingNotes"
          name="ChildReadingNotes"
          rows="4"
          cols="50"
          v-model="userBook.notes"
          
        /><br />
        <button class="btn" type="submit" v-on:click="LogReading">
          Submit Note
        </button>
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
</style>