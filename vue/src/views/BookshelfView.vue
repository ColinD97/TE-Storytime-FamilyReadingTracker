<template>
<div>
  <div class="add-book">
    <h1 class="title">BookShelf</h1>
    <h3 class="subtext">Let's go on a reading adventure!</h3>
<table class="bookshelf" >
    <thead class='table-header'>
    <tr class='header-row'>
        <th>Current Books</th>
        <th>Books To-read</th>
        <th>Books Read</th>
    </tr>
  </thead>
  <tbody>
    <tr class='table-row'>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr class='table-row'>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr class='table-row'>
        <td></td>
        <td></td>
        <td></td>
    </tr>
  </tbody>
</table>
</div>
  <add-book />
</div>
</template>

<script>
import AddBook from '@/components/AddBook'

export default {
  components: {
    AddBook
  },  
}
</script>

<style>

</style>