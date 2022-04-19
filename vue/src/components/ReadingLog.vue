<template>
  <div class="reading-log">
  <div>
    <form class="form-reading-log">
      <h1 class="form-header">Log Reading</h1>
      <div class="form-body">
        <!-- Reader and Book -->
      <div class="horizontal-group">
        <div class="form-group-wide left">
          <div class='split-form-one-group-left'>
            
            
            <!-- Thought we could implement this somehow to swap between parent or child presentation of form but it disappeared from view on page now and IDK why -->
            <div v-if="isParent">
              <label class="label-title" for="readers">Reader</label>
                  <select
                    class="drop-down"
                    name="readers"
                    id="readers"
                    v-model="userBook.user_id"
                    required
                    autofocus
                  >
                    <option disabled hidden value="">Pick a Reader</option>
                    <option v-for="user in familyUsers" v-bind:key="user.index"
                      :value="user.id">
                      {{ user.first_name }}
                    </option></select
                  ><br />
            </div>
            
            
            <div v-else>
              <p class="label-title" for="readers">{{this.$.store.state.user.first_name}}</p>
            </div>
          
          </div>
           <div class='split-form-two-group-left'>
            <label for="MinutesRead" class="label-title">Minutes Read</label>
              <input
                type="text"
                id="minutesread"
                name="MinutesRead"
                v-model="userBook.minutes_read"
              />
          </div> 
        </div>
        <div class="form-group-narrow right">
            <label for="FinishedBookCheckbox" class="label-title">Finished Book?</label>
            <input
              type="checkbox"
              id="finishedbookcheckbox"
              v-model="userBook.times_read"
              value="true"
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
              v-model="userBook.reading_format"
              autofocus
            >
              <option disabled hidden value="">Pick Book Format</option>
              <option selected value="Paper">Paper</option>
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
              v-model="userBook.book_id"
              autofocus>
              <option disabled hidden value="">Pick a Book</option>
              <option v-for="book in familyBooks" v-bind:key="book.index"
                :value="book.book_id">
                {{ book.title }}
              </option></select>
          </div>
        </div>
        <div class="form-group-narrow right">
          <label for="ChildReadingNotes" class="label-title">Notes</label><br />
          <textarea
            id="childreadingnotes"
            name="ChildReadingNotes"
            rows="4"
            cols="40"
            v-model="userBook.notes" 
          /><br />
        </div>
      </div>
    </div>
      <div class="form-footer">
        <button class="btn" type="submit" v-on:click="LogReading">
        Submit
        </button>
      </div>
    </form>
</div>
</div>
</template>

<script>
import BookService from "@/services/BookService.js";

export default {
  name: "ReadingLog",
  props: ['familyUsers'], 
  data() {
    return {
      userBook: {
        user_id: "",
        book_id: "",
        minutes_read: "",
        reading_format: "Paper",
        times_read: "",
        notes: ""
      },
      familyBooks: [],
    };
  },
  methods: {
    LogReading() {
      console.log("Checking for userID" + this.userId);
      if (this.userBook.times_read === true) {
        this.userBook.times_read = 1
      }
      BookService.logReading(this.userBook);
      BookService.getAllBooksByFamily(this.$store.state.user.family_id).then((response) => {
        this.familyBooks = response.data;
      })
    },
  },

  created() {
    BookService.getAllBooksByFamily(this.$store.state.user.family_id).then((response) => {
      this.familyBooks = response.data;
      })
    },
  
  computed: {
  isParent: function () {
    if (this.$store.state.user.authorities[0].name == "ROLE_PARENT") {
      return true;
    } else {
      return false;
    }
  },
  },
 }
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