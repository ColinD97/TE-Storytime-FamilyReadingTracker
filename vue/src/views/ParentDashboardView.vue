<template>
<div>
  <parent-dashboard />
  <add-book />
</div>
</template>

<script>
import ParentDashboard from '@/components/ParentDashboard'
import AddBook from '../components/AddBook.vue'

export default {
  components: {
    ParentDashboard,
    AddBook
  },  
}
</script>

<style>

</style>