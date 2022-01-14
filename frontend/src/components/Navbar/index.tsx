import { ReactComponent as GitHubIcon } from '../../assets/img/github.svg';
import './styles.css';

function Navbar() {
    return (
        <header>
            <nav className='container'>
                <div className='rafamovies-nav-content'>
                    <h1>Rafa Movies</h1>
                    <a href='https://github.com/rmarinheiro'>
                        <div className='rafamovis-contact-container'>
                            <GitHubIcon />
                            <p className='rafamovies-contact-link'>/rmarinheiro</p>
                        </div>
                    </a>
                </div>

            </nav>
        </header>
    );
}

export default Navbar;