# Sainsburys Scraper

# Usage instructions
Hello there :) This is my attempt at creating an extensible web scraper for the Sainsbury's 
groceries website.

![dev vs client](https://media1.tenor.com/images/c8069eb379fdb4b2f2bc8779869ce959/tenor
.gif?itemid=8105335)

To build the project, run: 

`./gradlew build`

To run all tests, run:

`./gradlew test`

To run the project, run:

`./gradlew run`


# Decision log
- I decided to use a gradle wrapper in case you dont own the library or the correct version on your
 machine.
- I assumed that anything that has less than 0.5g of kcal will be considered as 0 kcal (or 
non-existent)
- I assumed that an unavailable description means you wont want to see it in the JSON

# Results
Here are the results from the given link:
``````
{
  "results": [
    {
      "title": "Sainsbury's Strawberries 400g",
      "kcal_per_100g": 140,
      "unit_price": 1.75,
      "description": "by Sainsbury's strawberries"
    },
    {
      "title": "Sainsbury's Blueberries 200g",
      "kcal_per_100g": 189,
      "unit_price": 1.75,
      "description": "by Sainsbury's blueberries"
    },
    {
      "title": "Sainsbury's Raspberries 225g",
      "kcal_per_100g": 133,
      "unit_price": 1.75,
      "description": "by Sainsbury's raspberries"
    },
    {
      "title": "Sainsbury's Blackberries, Sweet 150g",
      "kcal_per_100g": 134,
      "unit_price": 1.5,
      "description": "by Sainsbury's blackberries"
    },
    {
      "title": "Sainsbury's Blueberries 400g",
      "kcal_per_100g": 189,
      "unit_price": 3.25,
      "description": "by Sainsbury's blueberries"
    },
    {
      "title": "Sainsbury's Blueberries, SO Organic 150g",
      "unit_price": 2.0,
      "description": "So Organic blueberries"
    },
    {
      "title": "Sainsbury's Raspberries, Taste the Difference 150g",
      "kcal_per_100g": 133,
      "unit_price": 2.5,
      "description": "Ttd raspberries"
    },
    {
      "title": "Sainsbury's Cherries 400g",
      "unit_price": 2.5,
      "description": "by Sainsbury's Family Cherry Punnet"
    },
    {
      "title": "Sainsbury's Blackberries, Tangy 150g",
      "kcal_per_100g": 134,
      "unit_price": 1.5,
      "description": "by Sainsbury's blackberries"
    },
    {
      "title": "Sainsbury's Strawberries, Taste the Difference 300g",
      "kcal_per_100g": 140,
      "unit_price": 2.5,
      "description": "Ttd strawberries"
    },
    {
      "title": "Sainsbury's Cherry Punnet 200g",
      "unit_price": 1.5
    },
    {
      "title": "Sainsbury's Mixed Berries 300g",
      "unit_price": 3.5,
      "description": "by Sainsbury's mixed berries"
    },
    {
      "title": "Sainsbury's Mixed Berry Twin Pack 200g",
      "unit_price": 2.75
    },
    {
      "title": "Sainsbury's Redcurrants 150g",
      "kcal_per_100g": 300,
      "unit_price": 2.5,
      "description": "by Sainsbury's redcurrants"
    },
    {
      "title": "Sainsbury's Cherry Punnet, Taste the Difference 200g",
      "kcal_per_100g": 203,
      "unit_price": 2.5,
      "description": "Cherry Punnet"
    },
    {
      "title": "Sainsbury's Blackcurrants 150g",
      "unit_price": 1.75
    },
    {
      "title": "Sainsbury's British Cherry & Strawberry Pack 600g",
      "unit_price": 4.0
    }
  ],
  "total": 39.5
}
``````
I've been a bit naughty and decided to find the real Sainsbury's website to test whether my code 
really works in 'production' (lol):

Here are the results for that:

``````
{
  "results": [
    {
      "title": "Sainsbury's Strawberries 400g",
      "kcal_per_100g": 140,
      "unit_price": 2.0,
      "description": "by Sainsbury's strawberries"
    },
    {
      "title": "Sainsbury's Raspberries 150g",
      "kcal_per_100g": 133,
      "unit_price": 2.0,
      "description": "by Sainsbury's raspberries"
    },
    {
      "title": "Sainsbury's Blueberries 150g",
      "kcal_per_100g": 189,
      "unit_price": 2.0,
      "description": "by Sainsbury's blueberries"
    },
    {
      "title": "Sainsbury's Raspberries 225g",
      "kcal_per_100g": 133,
      "unit_price": 2.85,
      "description": "by Sainsbury's raspberries"
    },
    {
      "title": "Sainsbury's Strawberries 227g",
      "kcal_per_100g": 140,
      "unit_price": 1.75,
      "description": "by Sainsbury's strawberries"
    },
    {
      "title": "Sainsbury's Blackberries, Sweet 150g",
      "kcal_per_100g": 134,
      "unit_price": 2.0,
      "description": "by Sainsbury's blackberries"
    },
    {
      "title": "Sainsbury's Blueberries, SO Organic 150g",
      "unit_price": 2.7,
      "description": "So Organic blueberries"
    },
    {
      "title": "Sainsbury's Strawberries, Greengrocer 250g",
      "kcal_per_100g": 140,
      "unit_price": 1.1,
      "description": "Strawberries"
    },
    {
      "title": "Sainsbury's Raspberries, Taste the Difference 150g",
      "kcal_per_100g": 133,
      "unit_price": 2.75,
      "description": "Ttd raspberries"
    },
    {
      "title": "Sainsbury's Blackberries, Tangy 150g",
      "kcal_per_100g": 134,
      "unit_price": 2.0,
      "description": "by Sainsbury's blackberries"
    },
    {
      "title": "Sainsbury's Strawberries, Taste the Difference 300g",
      "kcal_per_100g": 140,
      "unit_price": 3.0,
      "description": "Ttd strawberries"
    },
    {
      "title": "Sainsbury's Strawberries, SO Organic 300g",
      "kcal_per_100g": 140,
      "unit_price": 2.5,
      "description": "SO Organic strawberries"
    },
    {
      "title": "Sainsbury's Raspberries, SO Organic 125g",
      "kcal_per_100g": 133,
      "unit_price": 2.5,
      "description": "SO Organic raspberries"
    },
    {
      "title": "Sainsbury's Mixed Berries 300g",
      "unit_price": 3.5,
      "description": "by Sainsbury's mixed berries"
    },
    {
      "title": "Sainsbury's Mixed Berry Twin Pack 200g",
      "unit_price": 3.0
    },
    {
      "title": "Sainsbury's Blackberries, Tangy 225g",
      "kcal_per_100g": 134,
      "unit_price": 2.85,
      "description": "by Sainsbury's blackberries"
    },
    {
      "title": "Sainsbury's Extra Large Blueberries 200g",
      "unit_price": 2.0
    }
  ],
  "total": 40.5
}
``````