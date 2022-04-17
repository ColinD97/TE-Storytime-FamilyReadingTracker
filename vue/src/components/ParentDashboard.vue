<template> 
    <div class="parent-dashboard">
      <div class="title">
        <h1>Parent Dashboard<span>Keep track of your kid's reading. Build habits for life.</span></h1>
      </div>
      
      <table class="parent">
      <label for="Children"></label>
        <tr>
          <th>Child</th>
          <th>Number of Books Completed</th>
          <th>Minutes Read</th>
          <th>Current Book</th>
          <th>Points Balance</th>
        </tr>
        <tr v-for="user in familyUsers" :key="user.id">
          <td>{{user.first_name}}</td>
          <td>still need</td>
          <td>{{user.totalMinutes}}</td>
          <td>still need</td>
          <td>{{user.pointsBalance}}</td>
        </tr>
      </table> 
      <div class="dash-buttons">
        <button class='btn' @click="$router.push('/reading-log/user')">Log Reading </button>
        <button class='btn' @click="$router.push('')">Prize Dashboard </button>
        <button class='btn' @click="$router.push('/bookshelf/{{user.id}}')">Bookshelf </button>
      </div>
       

      <add-book v-bind:familyUsers="familyUsers"/>
      <!-- v-for="name in this.familyUsers" v-bind:key="name.id" v-bind:familyUsers="name"/>/ -->
      <!-- I'm positive I'm not getting this right. Spent 45 mins trying to research what goes where and moving on to CSS just for a bit -->
      <registration-form-child />

     
  </div>
</template>

<script>
import AuthService from "@/services/AuthService";
import AddBook from './AddBook.vue';
import RegistrationFormChild from './RegistrationFormChild.vue'

export default {
  components: { AddBook, RegistrationFormChild },
// create + data (empty group of users that I will fill with this return request)
  name: 'parent-dashboard-userID',          // Spot check this with the team. 
  // Reg Note:  If I need to do a PROP, it's here
  data() {
    return {
      // user: {         // Spot check this with the team.  
      //   id: '',              
      // },
      familyUsers: [],
      // currentUserId: this.$route.params.userId    


      // 2) Notes for Kai: pass this array into the add book as a prop. inside add a book they can see the family user array coming in as props. use in v-for 

    }
  },
    computed: {
    currentUserId: function(){
      return this.$store.state.user.id
    }
  },
  methods: {
    goToRegisterChild(){
      this.$router.push({name: 'register-child'})
    }
  },

created() {
    AuthService
      .getFamilyByUserId(this.currentUserId)
      .then(response => {
          this.familyUsers = response.data;
      })
  }
}

</script>

<style>
.dash-buttons{
  padding:10px;
  display:flex;
  justify-content: space-around;

}
.parent {
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  justify-content: center;
}
.parent td, .parent th {
  border: 1px solid #bbf2fc;
  padding: 8px;
}
.parent tr:nth-child(even){background-color: #f2f2f2;}

.parent tr:hover {background-color: #ddd;}

.parent th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #126c7c;
  color: white;
}

</style>