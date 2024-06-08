import random as rd
from enum import Enum
from typing import IO, List, NamedTuple

# ENUMS AND TUPLES -- Data Classes
class ShapeKind(str, Enum):
    """Supported shape kinds"""
    CIRCLE = 0
    RECTANGLE = 1
    ELLIPSE = 2

    def __str__(self) -> str:
        return f'{self.value}'

class Irange(NamedTuple):
    """A simple integer range with minimum and maximum values"""
    imin: int
    imax: int

    def __str__(self) -> str:
        return f'{self.imin},{self.imax}'

class Frange(NamedTuple):
    """A simple float range with minimum and maximum values"""
    fmin: float
    fmax: float

    def __str__(self) -> str:
        return f'{self.fmin},{self.fmax}'


class Extent(NamedTuple):
    """Extent definition based on width and height ranges"""
    width: Irange
    height: Irange

    def __str__(self) -> str:
        return f'({self.width},{self.height})'
    
class Color(NamedTuple):
    """RGB color definition based on integer ranges"""
    red: Irange
    green: Irange
    blue: Irange
    opacity: Frange

    def __str__(self) -> str:
        return f'({self.red},{self.green},{self.blue})'

 # STATIC FUNCTIONS
def gen_int(r: Irange) -> int:
    """Generates a random integer"""
    return rd.randint(r.imin, r.imax)

def gen_float(r: Frange) -> float:
    """Generates a random float"""
    return rd.uniform(r.fmin, r.fmax)


# DOMAIN CLASSES
class PyArtConfig:
    """Input configuration to guide the art style (e.g., fall
    colours pointilistic) to be applied to random shapes"""
    pass
                    

class HtmlDocument:
    """An HTML document that allows appending SVG content"""
    TAB: str = "   "  # HTML indentation tab (default: three spaces)

    def __init__(self, file_name: str, win_title: str) -> None:
        self.win_title: str = win_title
        self.__tabs: int = 0
        self.__file: IO = open(file_name, "w")
        self.__write_head()

    def increase_indent(self) -> None:
        """Increases the number of tab characters used for indentation"""
        self.__tabs += 1

    def decrease_indent(self) -> None:
        """Decreases the number of tab characters used for indentation"""
        self.__tabs -= 1

    def append(self, content: str) -> None:
        """Appends the given HTML content to this document"""
        ts: str = HtmlDocument.TAB * self.__tabs
        self.__file.write(f'{ts}{content}\n')

    def __write_head(self) -> None:
        """Appends the HTML preamble to this document"""
        self.append('<html>')
        self.append('<head>')
        self.increase_indent()
        self.append(f'<title>{self.win_title}</title>')
        self.decrease_indent()
        self.append('</head>')
        self.append('<body>')

    def __write_comment(self, comment: str) -> None:
        """Appends an HTML comment to this document"""
        self.append(f'<!--{comment}-->')

    # more methods needed here

class RandomShape:
    """A shape that can take the form of any type of supported shape"""
    pass                            
                            
class CircleShape:
    """A circle shape representing an SVG circle element"""
    ccnt: int = 0  # counting number of circles being constructed

    @classmethod
    def get_circle_count(cls) -> int:
        return CircleShape.ccnt

    def __init__(self, rs: RandomShape) -> None:
        """Initializes a circle"""
        self.sha: int = 0
        self.ctx: int = rs.rpt[0]
        self.cty: int = rs.rpt[1]
        self.rad: int = rs.rad
        self.red: int = rs.col[0]
        self.gre: int = rs.col[1]
        self.blu: int = rs.col[2]
        self.op: float = rs.col[3]

    def as_svg(self) -> str:
        """Produces the SVG code representing this shape"""
        return f'<circle cx="{self.ctx}" cy="{self.cty}" r="{self.rad}" ' \
               f'fill="rgb({self.red},{self.gre},{self.blu})" ' \
               f'fill-opacity="{self.op}"></circle>'

    def __str__(self) -> str:
        """String representation of this shape"""
        return f'\nGenerated random circle\n' \
               f'shape = {self.sha}\n' \
               f'radius = {self.rad}\n' \
               f'(centerx, centery) = ({self.ctx},{self.cty})\n' \
               f'(red, green, blue) = ({self.red},{self.gre},{self.blu})\n' \
               f'opacity = {self.op:.1f}\n'
        
class RectangleShape:
    """A rectangle shape that can be drawn as an SVG rect element"""
    pass

def main() -> None:
    """Generate at least three HTML documents with different art styles"""
    print(f'Circles generated: {CircleShape.ccnt}')
    
main()
