<template> 
    <div class="parent-dashboard">
      <div class="title">
        <h1>Parent Dashboard<span>Keep track of your kid's reading. Build habits for life.</span></h1>
      </div>
      <div class="box"> 
        <div class="left-side">
          <div class="grid-item-1">
            <table class="parent">
            <label for="Children"></label>
              <tr>
                <th class='left-end-top'>Child</th>
                <th class='middle'>Books Completed</th>
                <th class='middle'>Minutes Read</th>
                <th class='middle'>Current Book</th>
                <th class='right-end-top'>Points Balance</th>
              </tr>
              <tr v-for="user in familyUsers" :key="user.id">
                <td class='left-end'>{{user.first_name}}</td>
                <td class='middle'>{{user.books_read}}</td>
                <td class='middle'> {{user.total_minutes_read}}</td>
                <td class='middle'>still need</td>
                <td class='right-end'>{{user.points_balance}}</td>
              </tr>
            </table> 
          </div>
          <img src="@/assets/Dashboard.png" class="grid-item-2"/>
        </div>
      <div class="right-side">
        <reading-log v-bind:familyUsers="familyUsersAll" />
        <add-book v-bind:familyUsers="familyUsersAll"/>
        <registration-form-child /> 
      </div> 
    </div>    
  </div>
</template>

<script>
import AuthService from "@/services/AuthService";
import BookService from "@/services/BookService";
import AddBook from './AddBook.vue';
import RegistrationFormChild from './RegistrationFormChild.vue'
import ReadingLog from './ReadingLog.vue'

export default {
  components: { AddBook, RegistrationFormChild, ReadingLog },
// create + data (empty group of users that I will fill with this return request)
  name: 'parent-dashboard-userID',          // Spot check this with the team. 
  // Reg Note:  If I need to do a PROP, it's here
  data() {
    return {

      familyUsers: [],
      userData: [],
      familyUsersAll: []


      // 2) Notes for Kai: pass this array into the add book as a prop. inside add a book they can see the family user array coming in as props. use in v-for 

    }
  },
    computed: {
    currentUserId: function(){
      return this.$store.state.user.id
    }, 
    // logForUserId(){
    //   user_id: 
    //   }
  },
  methods: {
    goToRegisterChild(){
      this.$router.push({name: 'register-child'})
    },
    getReadingLog(logForUserId){
      BookService.getReadingLog(logForUserId).then(response => {
        this.userData = response.data
      })
    }
  },

created() {
    AuthService.getFamilyByUserId(this.currentUserId).then(response => {
          this.familyUsersAll = response.data;
      })
    // BookService.getReadinglog()
    console.log('create getDashboardInfo')
    AuthService.getDashboardInfo(this.$store.state.user.family_id).then(response => {
      this.familyUsers = response.data
    })
  }
}

</script>

<style>
.box{
  display: flex;
  justify-content: space-around;
}
.parent {
  padding-top: 40px;
  float: left;
  width: 100%;
  justify-content: center;
}
.parent td, .parent th {
  border: 1px solid #f3f7f4;
  padding: 8px;
}
.parent tr:nth-child(even){background-color: #ffffff;}

.parent tr:hover {background-color: #d1e6d6}

.parent th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #126c7c;
  color: #f2f7f3;
}
.left-end{
border-radius: 8px 3px 3px 8px;
}
.middle {
border-radius: 3px 3px 3px 3px;
}
.right-end{
border-radius: 3px 8px 8px 3px;
}
.right-end-top{
border-radius: 3px 8px 5px 3px;
}
.left-end-top {
border-radius: 8px 3px 3px 5px;
}

</style>