import urllib

# START FUNCTIONS

def getInfo(span):
	zacetekCas = 0
	konecCas = span.find("<br/>")
	cas = span[zacetekCas:konecCas].lstrip(" ").rstrip(" ")

	zacetekDan = 0;
	konecDan = cas.find(" ")
	dan = cas[zacetekDan:konecDan]

	zacetekUra = konecDan+1
	ura = cas[zacetekUra:]

	uraZacetka = ura[0:ura.find(" ")]
	uraKonca = ura[ura.rfind(" ")+1:]

	zacetekKraj = konecCas+7
	konecKraj = span.find("<br/>", zacetekKraj)
	kraj = span[zacetekKraj:konecKraj].lstrip(" ")
	kraj = kraj[0:kraj.find(" ")]

	zacetekPredmet = konecKraj+7
	konecPredmet = span.find("<br/>", zacetekPredmet)
	predmet = span[zacetekPredmet:konecPredmet].lstrip(" ")
	predmet = predmet[0:predmet.find("(")]

	print cas
	print dan
	print ura
	print uraZacetka
	print uraKonca
	print kraj
	print predmet
	return


# END FUNCTIONS

url = "https://urnik.fri.uni-lj.si/timetable/fri-2016_2017-zimski-drugi-teden/allocations?student=63160303"
f = urllib.urlopen(url)
# print f.read()
htmlFile = f.read()

konecSpan = 0
zacetekSpan = zacetekSpan = htmlFile.find("<span>", konecSpan)
konecSpan = htmlFile.find("</span>", zacetekSpan)
span = htmlFile[zacetekSpan+8:konecSpan]

getInfo(span)

zacetekSpan = zacetekSpan = htmlFile.find("<span>", konecSpan)
konecSpan = htmlFile.find("</span>", zacetekSpan)
span = htmlFile[zacetekSpan+8:konecSpan]

getInfo(span)



