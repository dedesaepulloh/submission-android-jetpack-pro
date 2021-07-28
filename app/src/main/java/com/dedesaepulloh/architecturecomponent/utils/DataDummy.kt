package com.dedesaepulloh.architecturecomponent.utils

import com.dedesaepulloh.architecturecomponent.data.model.MovieEntity
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.movie.MovieResponse
import com.dedesaepulloh.architecturecomponent.data.source.remote.response.tvshow.TvShowResponse

object DataDummy {
    fun generateDummyPopularMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "508943",
                "Luca",
                "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
                5609.753,
                "jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
                "2021-06-17",
                8.2
            )
        )
        movies.add(
            MovieEntity(
                "520763",
                "A Quiet Place Part II",
                "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.",
                3051.945,
                "4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
                "2021-05-21",
                7.9,
            )
        )
        movies.add(
            MovieEntity(
                "385128",
                "F9",
                "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
                3231.578,
                "bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
                "2021-05-19",
                7.8,
            )
        )
        movies.add(
            MovieEntity(
                "337404",
                "Cruella",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                2505.443,
                "rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "2021-05-26",
                8.5,
            )
        )
        movies.add(
            MovieEntity(
                "637649",
                "Wrath of Man",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                2169.355,
                "M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                "2021-04-22",
                7.8,
            )
        )
        movies.add(
            MovieEntity(
                "423108",
                "The Conjuring: The Devil Made Me Do It",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                1830.777,
                "xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                "2021-05-25",
                8.0
            )
        )
        movies.add(
            MovieEntity(
                "615658",
                "Awake",
                "After a sudden global event wipes out all electronics and takes away humankind’s ability to sleep, chaos quickly begins to consume the world. Only Jill, an ex-soldier with a troubled past, may hold the key to a cure in the form of her own daughter. The question is, can Jill safely deliver her daughter and save the world before she herself loses her mind.",
                1395.595,
                "uZkNbB8isWXHMDNoIbqXvmslBMC.jpg",
                "2021-06-09",
                6.2,
            )
        )
        movies.add(
            MovieEntity(
                "460465",
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                1374.407,
                "nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "2021-04-07",
                7.5,
            )
        )
        movies.add(
            MovieEntity(
                "503736",
                "Army of the Dead",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                1447.641,
                "z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                "2021-05-14",
                6.5,
            )
        )
        movies.add(
            MovieEntity(
                "399566",
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                1281.186,
                "pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                8.0
            )
        )
        movies.add(
            MovieEntity(
                "717192",
                "Ferry",
                "Before he built a drug empire, Ferry Bouman returns to his hometown on a revenge mission that finds his loyalty tested — and a love that alters his life.",
                973.37,
                "srYGZ1rd9rvzwAltcKREUdS1JSQ.jpg",
                "2021-05-14",
                7.0
            )
        )
        movies.add(
            MovieEntity(
                "550205",
                "Wish Dragon",
                "Determined teen Din is longing to reconnect with his childhood best friend when he meets a wish-granting dragon who shows him the magic of possibilities.",
                1088.933,
                "lnPf6hzANL6pVQTxUlsNYSuhT5l.jpg",
                "2021-01-15",
                8.3
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<MovieEntity> {
        val tvshow = ArrayList<MovieEntity>()

        tvshow.add(
            MovieEntity(
                "84958",
                "Loki",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                4958.137,
                "kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                "2021-06-09",
                8.1
            )
        )
        tvshow.add(
            MovieEntity(
                "119243",
                "iCarly",
                "Ten years after signing off of one of TV's most iconic shows, Carly, Spencer, and Freddie are back, navigating the next chapter of their lives, facing the uncertainties of life in their twenties.",
                1133.451,
                "s5k4GqTUGXeUdScNrjpYfiQLKHI.jpg",
                "2021-06-17",
                7.9
            )
        )
        tvshow.add(
            MovieEntity(
                "76669",
                "Elite",
                "When three working class kids enroll in the most exclusive school in Spain, the clash between the wealthy and the poor students leads to tragedy.",
                1526.453,
                "3NTAbAiao4JLzFQw6YxP1YZppM8.jpg",
                "2018-10-05",
                8.2
            )
        )
        tvshow.add(
            MovieEntity(
                "60625",
                "Rick and Morty",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                1464.464,
                "8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
                "2013-12-02",
                8.8
            )
        )
        tvshow.add(
            MovieEntity(
                "60735",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                987.751,
                "lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "2014-10-07",
                7.7
            )
        )
        tvshow.add(
            MovieEntity(
                "88396",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                566.655,
                "6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "2021-03-19",
                7.8
            )
        )
        tvshow.add(
            MovieEntity(
                "63174",
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                931.278,
                "4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                8.5
            )
        )
        tvshow.add(
            MovieEntity(
                "114868",
                "Record of Ragnarok",
                "Before eradicating humankind from the world, the gods give them one last chance to prove themselves worthy of survival. Let the Ragnarok battles begin.",
                847.252,
                "kTs2WNZOukpWdNhoRlH94pSJ3xf.jpg",
                "2021-06-17",
                8.9
            )
        )
        tvshow.add(
            MovieEntity(
                "71712",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                798.772,
                "6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "2017-09-25",
                8.6
            )
        )
        tvshow.add(
            MovieEntity(
                "95057",
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                662.11,
                "vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                "2021-02-23",
                8.3
            )
        )
        tvshow.add(
            MovieEntity(
                "104157",
                "Katla",
                "A year after a subglacial volcano erupts, mysterious elements from prehistoric times emerge from the melting ice, bringing unforeseen consequences.",
                453.474,
                "vRPDQP51i1Z2RuoIQaxVSj7Pd5R.jpg",
                "2021-06-17",
                7.2
            )
        )
        tvshow.add(
            MovieEntity(
                "103768",
                "Sweet Tooth",
                "On a perilous adventure across a post-apocalyptic world, a lovable boy who's half-human and half-deer searches for a new beginning with a gruff protector.",
                479.665,
                "rgMfhcrVZjuy5b7Pn0KzCRCEnMX.jpg",
                "2021-06-04",
                8.0
            )
        )

        return tvshow
    }

    fun generateDummyMovieResponse(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                508943,
                "Luca",
                "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
                5609.753,
                "jTswp6KyDYKtvC52GbHagrZbGvD.jpg",
                "2021-06-17",
                8.2
            )
        )
        movies.add(
            MovieResponse(
                520763,
                "A Quiet Place Part II",
                "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.",
                3051.945,
                "4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
                "2021-05-21",
                7.9,
            )
        )
        movies.add(
            MovieResponse(
                385128,
                "F9",
                "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
                3231.578,
                "bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
                "2021-05-19",
                7.8,
            )
        )
        movies.add(
            MovieResponse(
                337404,
                "Cruella",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                2505.443,
                "rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "2021-05-26",
                8.5,
            )
        )
        movies.add(
            MovieResponse(
                637649,
                "Wrath of Man",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                2169.355,
                "M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                "2021-04-22",
                7.8,
            )
        )
        movies.add(
            MovieResponse(
                423108,
                "The Conjuring: The Devil Made Me Do It",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                1830.777,
                "xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                "2021-05-25",
                8.0
            )
        )
        movies.add(
            MovieResponse(
                615658,
                "Awake",
                "After a sudden global event wipes out all electronics and takes away humankind’s ability to sleep, chaos quickly begins to consume the world. Only Jill, an ex-soldier with a troubled past, may hold the key to a cure in the form of her own daughter. The question is, can Jill safely deliver her daughter and save the world before she herself loses her mind.",
                1395.595,
                "uZkNbB8isWXHMDNoIbqXvmslBMC.jpg",
                "2021-06-09",
                6.2,
            )
        )
        movies.add(
            MovieResponse(
                460465,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                1374.407,
                "nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "2021-04-07",
                7.5,
            )
        )
        movies.add(
            MovieResponse(
                503736,
                "Army of the Dead",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                1447.641,
                "z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                "2021-05-14",
                6.5,
            )
        )
        movies.add(
            MovieResponse(
                399566,
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                1281.186,
                "pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                8.0
            )
        )
        movies.add(
            MovieResponse(
                717192,
                "Ferry",
                "Before he built a drug empire, Ferry Bouman returns to his hometown on a revenge mission that finds his loyalty tested — and a love that alters his life.",
                973.37,
                "srYGZ1rd9rvzwAltcKREUdS1JSQ.jpg",
                "2021-05-14",
                7.0
            )
        )
        movies.add(
            MovieResponse(
                550205,
                "Wish Dragon",
                "Determined teen Din is longing to reconnect with his childhood best friend when he meets a wish-granting dragon who shows him the magic of possibilities.",
                1088.933,
                "lnPf6hzANL6pVQTxUlsNYSuhT5l.jpg",
                "2021-01-15",
                8.3
            )
        )

        return movies
    }

    fun generateDummyTvShowResponse(): List<TvShowResponse> {
        val tvshow = ArrayList<TvShowResponse>()

        tvshow.add(
            TvShowResponse(
                84958,
                "Loki",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                4958.137,
                "kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                "2021-06-09",
                8.1
            )
        )
        tvshow.add(
            TvShowResponse(
                119243,
                "iCarly",
                "Ten years after signing off of one of TV's most iconic shows, Carly, Spencer, and Freddie are back, navigating the next chapter of their lives, facing the uncertainties of life in their twenties.",
                1133.451,
                "s5k4GqTUGXeUdScNrjpYfiQLKHI.jpg",
                "2021-06-17",
                7.9
            )
        )
        tvshow.add(
            TvShowResponse(
                76669,
                "Elite",
                "When three working class kids enroll in the most exclusive school in Spain, the clash between the wealthy and the poor students leads to tragedy.",
                1526.453,
                "3NTAbAiao4JLzFQw6YxP1YZppM8.jpg",
                "2018-10-05",
                8.2
            )
        )
        tvshow.add(
            TvShowResponse(
                60625,
                "Rick and Morty",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                1464.464,
                "8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
                "2013-12-02",
                8.8
            )
        )
        tvshow.add(
            TvShowResponse(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                987.751,
                "lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "2014-10-07",
                7.7
            )
        )
        tvshow.add(
            TvShowResponse(
                88396,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                566.655,
                "6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "2021-03-19",
                7.8
            )
        )
        tvshow.add(
            TvShowResponse(
                63174,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                931.278,
                "4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "2016-01-25",
                8.5
            )
        )
        tvshow.add(
            TvShowResponse(
                114868,
                "Record of Ragnarok",
                "Before eradicating humankind from the world, the gods give them one last chance to prove themselves worthy of survival. Let the Ragnarok battles begin.",
                847.252,
                "kTs2WNZOukpWdNhoRlH94pSJ3xf.jpg",
                "2021-06-17",
                8.9
            )
        )
        tvshow.add(
            TvShowResponse(
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                798.772,
                "6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "2017-09-25",
                8.6
            )
        )
        tvshow.add(
            TvShowResponse(
                95057,
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                662.11,
                "vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                "2021-02-23",
                8.3
            )
        )
        tvshow.add(
            TvShowResponse(
                104157,
                "Katla",
                "A year after a subglacial volcano erupts, mysterious elements from prehistoric times emerge from the melting ice, bringing unforeseen consequences.",
                453.474,
                "vRPDQP51i1Z2RuoIQaxVSj7Pd5R.jpg",
                "2021-06-17",
                7.2
            )
        )
        tvshow.add(
            TvShowResponse(
                103768,
                "Sweet Tooth",
                "On a perilous adventure across a post-apocalyptic world, a lovable boy who's half-human and half-deer searches for a new beginning with a gruff protector.",
                479.665,
                "rgMfhcrVZjuy5b7Pn0KzCRCEnMX.jpg",
                "2021-06-04",
                8.0
            )
        )

        return tvshow
    }

    fun generateDummyTrending(): List<MovieEntity> {
        val trending = ArrayList<MovieEntity>()

        trending.add(
            MovieEntity(
                "617502",
                "Jolt",
                "Lindy is an acid-tongued woman with rage issues who controls her temper by shocking herself with an electrode vest. One day she makes a connection with Justin, who gives her a glimmer of hope for a shock-free future, but when he’s murdered she launches herself on a revenge-fueled rampage in pursuit of his killer.",
                147.71,
                "gYZAHan5CHPFXORpQMvOjCTug4E.jpg",
                "2021-07-29",
                6.7
            )
        )
        trending.add(
            MovieEntity(
                "760883",
                "Blood Red Sky",
                "A woman with a mysterious illness is forced into action when a group of terrorists attempt to hijack a transatlantic overnight flight. In order to protect her son she will have to reveal a dark secret, and unleash the inner monster she has fought to hide.",
                265.454,
                "ky8Fua6PD7FyyOA7JACh3GDETli.jpg",
                "2021-07-23",
                7.6,
            )
        )
        trending.add(
            MovieEntity(
                "736074",
                "Batman: The Long Halloween, Part Two",
                "As Gotham City's young vigilante, the Batman, struggles to pursue a brutal serial killer, district attorney Harvey Dent gets caught in a feud involving the criminal family of the Falcones.",
                87.406,
                "5X1n5q08mZ7NpNpxehMFODxfNYq.jpg",
                "2021-07-26",
                7.0,
            )
        )
        trending.add(
            MovieEntity(
                "845222",
                "킹덤: 아신전",
                "Tragedy, betrayal and a mysterious discovery fuel a woman's vengeance for the loss of her tribe and family in this special episode of \"Kingdom.\"",
                159.386,
                "piGZDwFW4urLYDWGiYJMrt6hdCS.jpg",
                "2021-07-23",
                8.0,
            )
        )
        trending.add(
            MovieEntity(
                "497698",
                "Black Widow",
                "Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.",
                4719.094,
                "qAZ0pzat24kLdO3o8ejmbLxyOac.jpg",
                "2021-07-07",
                8.0,
            )
        )
        trending.add(
            MovieEntity(
                "379686",
                "Space Jam: A New Legacy",
                "When LeBron and his young son Dom are trapped in a digital space by a rogue A.I., LeBron must get them home safe by leading Bugs, Lola Bunny and the whole gang of notoriously undisciplined Looney Tunes to victory over the A.I.'s digitized champions on the court. It's Tunes versus Goons in the highest-stakes challenge of his life.",
                5712.919,
                "5bFK5d3mVTAvBCXi5NPWH0tYjKl.jpg",
                "2021-07-08",
                7.8
            )
        )
        trending.add(
            MovieEntity(
                "520763",
                "A Quiet Place Part II",
                "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path.",
                1215.898,
                "4q2hz2m8hubgvijz8Ez0T2Os2Yv.jpg",
                "2021-05-21",
                7.7,
            )
        )
        trending.add(
            MovieEntity(
                "602223",
                "The Forever Purge",
                "All the rules are broken as a sect of lawless marauders decides that the annual Purge does not stop at daybreak and instead should never end as they chase a group of immigrants who they want to punish because of their harsh historical past.",
                4309.826,
                "uHA5COgDzcxjpYSHHulrKVl6ByL.jpg",
                "2021-06-30",
                7.8,
            )
        )
        trending.add(
            MovieEntity(
                "522931",
                "Hitman's Wife's Bodyguard",
                "The world’s most lethal odd couple – bodyguard Michael Bryce and hitman Darius Kincaid – are back on another life-threatening mission. Still unlicensed and under scrutiny, Bryce is forced into action by Darius's even more volatile wife, the infamous international con artist Sonia Kincaid. As Bryce is driven over the edge by his two most dangerous protectees, the trio get in over their heads in a global plot and soon find that they are all that stand between Europe and a vengeful and powerful madman.",
                273.869,
                "6zwGWDpY8Zu0L6W4SYWERBR8Msw.jpg",
                "2021-06-14",
                7.0,
            )
        )
        trending.add(
            MovieEntity(
                "730840",
                "Trollhunters: Rise of the Titans",
                "Arcadia may look like an ordinary town, but it lies at the center of magical and mystical lines that makes it a nexus for many battles among otherworldly creatures, including trolls, aliens, and wizards. Now, various heroes will team-up in an epic adventure where they must fight the Arcane Order for control over the magic that binds them all together.",
                923.952,
                "zvUNFeTz0Sssb210wSiIiHRjA4W.jpg",
                "2021-07-21",
                8.0
            )
        )
        trending.add(
            MovieEntity(
                "385128",
                "F9",
                "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
                1613.337,
                "bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
                "2021-05-19",
                7.5
            )
        )
        trending.add(
            MovieEntity(
                "638449",
                "The Last Letter From Your Lover",
                "A young journalist in London becomes obsessed with a series of letters she discovers that recounts an intense star-crossed love affair from the 1960s.",
                70.61,
                "fDKK51YdOfu9pTmSRw7sHUhGFxm.jpg",
                "2021-07-30",
                7.6
            )
        )

        return trending
    }
}