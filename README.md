# prototype.pcpartpicker
Uses Jsoup and web scraping to dynamically display some elements from pcpartpicker.com
The basic layout of the app is as follows 
  Each button from the MainActivity.java starts an activity extending the ComputerPartActivity abstract class, which itself extends the AppCompatActivity.
  
  The ComputerPartActivities (Currently there are 9) inherit an AsyncTask which populates the RecyclerViews with cards containing that
  sweet, sweet pc part data. 
  
  The asynctask makes calls to two methods that are the bread and butter of this application (as well as do progress bar things),
  it calls PartPickerScraper.getRawData() which is passed a jsoup document from parsing the xmlhttp requests (Ajax) pcpartpicker uses
  to generate its pc part tables which returns String[][]. As you may have guessed this String[][] is the collection of pc parts, 
  each inner array represents a pc part (any pc part).
  
  The asynctask then calls PartPickerScraper.getUrlsFromDoc() passing it the same jsoup document and retrievs the urls for each part.
  
  This may seem complicated, but much of the heavy lifting is abstracted into methods right now. The main focus now is to add functionality
  to filter the parts by their more specific traits (manufacturer, size, etc). 
  
  Feel free to fork this and add your own functionality, being aware of the liscence and that fact that you are using copyrighted material.
